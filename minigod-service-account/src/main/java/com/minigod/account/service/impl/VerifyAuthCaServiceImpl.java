package com.minigod.account.service.impl;

import com.minigod.account.service.VerifyAuthCaService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.utils.JSONUtil;
import com.minigod.helper.bean.BaseBeanFactory;
import com.minigod.persist.account.mapper.VerifyAuthCaMapper;
import com.minigod.protocol.account.enums.VerifyAuthCaStatusEnum;
import com.minigod.protocol.account.model.VerifyAuthCa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@Slf4j
@RestController
public class VerifyAuthCaServiceImpl extends BaseBeanFactory implements VerifyAuthCaService {

    @Autowired
    VerifyAuthCaMapper verifyAuthCaMapper;

    @Override
    public void saveOrUpdateCaAuth(VerifyAuthCa verifyAuthCa) {
        // 参数校验
        if (verifyAuthCa == null || verifyAuthCa.getId() == null) {
            throw new InternalApiException(StaticType.CodeType.BAD_ARGS, StaticType.MessageResource.BAD_PARAMS);
        }

        VerifyAuthCa localAuthCa = verifyAuthCaMapper.selectByPrimaryKey(verifyAuthCa.getId());

        if (localAuthCa != null) {
            localAuthCa.setUpdateTime(new Date());
            verifyAuthCaMapper.updateByPrimaryKeySelective(localAuthCa);
        } else {
            localAuthCa = new VerifyAuthCa();
            localAuthCa.setCreateTime(new Date());
            localAuthCa.setUpdateTime(new Date());
            verifyAuthCaMapper.insertSelective(localAuthCa);
        }
    }

    @Override
    public VerifyAuthCa getValidAuthCa(String idCard) {
        List<VerifyAuthCa> validAuthCaList = verifyAuthCaMapper.selectByIdCardAndStatus(idCard, VerifyAuthCaStatusEnum.CA_P10.getCode());
        if (validAuthCaList.size() > 1) {
            log.error("CA认证本地校验数据异常：validAuthCaList = ", JSONUtil.toJson(validAuthCaList));
            throw new InternalApiException(StaticType.CodeType.ERROR_UNKNOWN, StaticType.MessageResource.ERROR_UNKNOWN);
        }

        if (validAuthCaList.size() == 1) {
            return validAuthCaList.get(0);
        }
        return null;
    }

    @Override
    public VerifyAuthCa getValidAuthCaById(Integer id) {
        VerifyAuthCa validAuthCa = verifyAuthCaMapper.selectByPrimaryKey(id);
        if (validAuthCa == null || !VerifyAuthCaStatusEnum.isFlag(validAuthCa.getStatus(), VerifyAuthCaStatusEnum.CA_P10)) {
            log.error("CA认证本地校验数据异常：validAuthCa = ", JSONUtil.toJson(validAuthCa));
            throw new InternalApiException(StaticType.CodeType.ERROR_UNKNOWN, StaticType.MessageResource.ERROR_UNKNOWN);
        }
        return validAuthCa;
    }

    @Override
    public List<VerifyAuthCa> getErrorVerifyAuthCa(String idCard) {
        return verifyAuthCaMapper.selectByIdCardAndStatusLessThan(idCard, VerifyAuthCaStatusEnum.CA_P10.getCode());
    }

    @Override
    public void clearErrorVerifyCa(String idCard) {
        verifyAuthCaMapper.deleteByIdCardAndStatusLessThan(idCard, VerifyAuthCaStatusEnum.CA_P10.getCode());
    }
}
