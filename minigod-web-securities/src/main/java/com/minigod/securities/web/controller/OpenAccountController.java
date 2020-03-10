package com.minigod.securities.web.controller;


import com.minigod.common.pojo.response.ResResult;
import com.minigod.protocol.account.vo.request.params.*;
import com.minigod.protocol.account.vo.response.OpenUserInfoResVo;
import com.minigod.protocol.account.vo.response.VerifyResVo;
import com.minigod.securities.annotation.LoginUser;
import com.minigod.protocol.account.enums.CubpMessageResource;
import com.minigod.account.service.OpenAccountService;
import com.minigod.account.service.VerifyService;
import com.minigod.common.exception.InternalApiException;
import com.minigod.common.exception.WebApiException;
import com.minigod.common.pojo.StaticType;
import com.minigod.common.pojo.request.BaseRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/open_api")
@Validated
@Slf4j
public class OpenAccountController {
    @Autowired
    private VerifyService verifyService;
    @Autowired
    private OpenAccountService openAccountService;

    /**
     * 获取用户开户进度
     */
    @PostMapping("/get_open_progress")
    public ResResult getOpenProgress(@LoginUser Integer userId, @RequestBody BaseRequest<OpenProgressReqParams> requestVo) {
        try {
            OpenProgressReqParams params = requestVo.getParams();

            OpenUserInfoResVo rt = openAccountService.getOpenProgress(userId, params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_EMAIL);
        }
    }

    /**
     * ocr识别 TODO
     */
    @PostMapping("/ocr_by_image")
    public ResResult ocrByImage(@LoginUser Integer userId, @RequestBody BaseRequest<OpenImgReqParams> requestVo) {
        // TODO: 身份证、银行卡等识别
        try {
            OpenImgReqParams params = requestVo.getParams();

            Object rt = openAccountService.ocrByImage(userId, params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_OCR);
        }
    }

    /**
     * ocr识别 TODO
     */
    @PostMapping("/ocr_by_card_type")
    public ResResult ocrByCardType(@LoginUser Integer userId, @RequestBody BaseRequest<OcrReqParams> requestVo) {
        // TODO: 身份证、银行卡等识别
        try {
            OcrReqParams params = requestVo.getParams();

            Object rt = openAccountService.ocrByCardType(userId, params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_OCR);
        }
    }

    /**
     * 手机号校验
     */
    @PostMapping("verify_phone")
    public ResResult verifyPhone(@RequestBody BaseRequest<VerifyReqParams> requestVo) {
        try {
            VerifyReqParams params = requestVo.getParams();

            VerifyResVo rt = verifyService.verifyPhone(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_PHONE);
        }
    }

    /**
     * 邮箱校验
     */
    @PostMapping("verify_email")
    public ResResult verifyEmail(@RequestBody BaseRequest<VerifyReqParams> requestVo) {
        try {
            VerifyReqParams params = requestVo.getParams();

            VerifyResVo rt = verifyService.verifyEmail(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_EMAIL);
        }
    }


    /**
     * 身份证校验
     *
     * @param requestVo VerifyReqParams { id_card, name }
     */
    @PostMapping("verify_id_card")
    public ResResult verifyIdCard(@RequestBody BaseRequest<VerifyReqParams> requestVo) {
        try {
            VerifyReqParams params = requestVo.getParams();

            VerifyResVo rt = verifyService.verifyIdCard(params);
            return ResResult.success(rt);

        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_ID_CARD);
        }
    }

    /**
     * 银行卡四要素校验
     *
     * @param requestVo VerifyReqParams Object { id_card, name, bankcard, phone }
     */
    @PostMapping("verify_bank_card_4e")
    public ResResult verifyBankCard4E(@RequestBody BaseRequest<VerifyReqParams> requestVo) {
        try {
            VerifyReqParams params = requestVo.getParams();

            VerifyResVo rt = verifyService.verifyBankCard4E(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_PHONE);
        }
    }

    /**
     * 获取配置数据
     */
    @PostMapping("/get_dictionary")
    public ResResult getDictionary(@RequestBody BaseRequest<DictionaryDataReqParams> requestVo) {
        try {
            DictionaryDataReqParams params = requestVo.getParams();
            List<Object> rt = openAccountService.getDictionaryData(params);
            return ResResult.success(rt);
        } catch (InternalApiException e) {
            throw new WebApiException(e.getCode(), e.getMessage(), e.getMessageResource());
        } catch (Exception e) {
            throw new WebApiException(StaticType.CodeType.DISPLAY_ERROR, CubpMessageResource.FAIL_VERIFY_PHONE);
        }

    }
}
