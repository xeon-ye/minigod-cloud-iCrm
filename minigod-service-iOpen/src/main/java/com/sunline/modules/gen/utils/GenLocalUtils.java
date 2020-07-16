package com.sunline.modules.gen.utils;

import com.sunline.MySpringBootApplication;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.gen.service.SysGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * 类的功能描述.
 *
 * @Auther hxy
 * @Date 2017/11/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MySpringBootApplication.class)
public class GenLocalUtils {
    @Resource
    private SysGeneratorService generatorService;

    @Test
    public void generatorCode(){
        byte[] bytes=generatorService.generatorCode(new String[]{"my_open_account_test"}, Constant.genType.local.getValue());
    }
}
