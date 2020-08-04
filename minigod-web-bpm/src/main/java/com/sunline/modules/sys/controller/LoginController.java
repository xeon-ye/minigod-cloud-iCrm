package com.sunline.modules.sys.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.sunline.modules.common.annotation.SysLog;
import com.sunline.modules.common.common.Constant;
import com.sunline.modules.common.controller.BaseController;
import com.sunline.modules.common.utils.AesEncryptUtil;
import com.sunline.modules.common.utils.Result;
import com.sunline.modules.common.utils.ShiroUtils;
import com.sunline.modules.common.utils.UserUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 类的功能描述.
 * 登录控制
 *
 * @Auther hxy
 * @Date 2017/4/28
 */
@Controller
public class LoginController extends BaseController {

    @Autowired
    private Producer captchaProducer;

    @RequestMapping("/login/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set to expire far in the past.
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");

        // return a jpeg
        response.setContentType("image/jpeg");

        // create the text for the image
        String capText = captchaProducer.createText();

        // store the text in the session
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        // create the image with the text
        BufferedImage bi = captchaProducer.createImage(capText);

        ServletOutputStream out = response.getOutputStream();

        // write the data out
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }

    }

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login/login", method = RequestMethod.POST)
    @SysLog("登录系统")
    public Result login(String username, String password, String captcha, boolean isRememberMe) throws Exception {
        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        String desEncryptPwd = AesEncryptUtil.desEncrypt(password, Constant.KEY, Constant.IV).trim();
        if (!captcha.equalsIgnoreCase(kaptcha)) {
            return Result.error("验证码不正确");
        }
        try {
            Subject subject = ShiroUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, desEncryptPwd);
//            token.setRememberMe(isRememberMe);
            subject.login(token);
        } catch (UnknownAccountException e) {
            return Result.error("帐号不存在！");
        } catch (IncorrectCredentialsException e) {
            return Result.error("密码不正确！");
        } catch (LockedAccountException e) {
            return Result.error("帐号已被锁定，请联系管理员！");
        } catch (DisabledAccountException e) {
            return Result.error("帐号已经禁止登录！");
        } catch (AuthenticationException e) {
            return Result.error("帐号验证失败！");
        }

        return Result.ok();
    }

    /**
     * 方法logOut的功能描述:
     * 退出登录
     *
     * @return java.lang.String
     * @params []
     * @auther hxy
     * @date 2017-05-02 14:01:23
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    @SysLog("退出系统")
    public String logOut() {
        String loginName = UserUtils.getCurrentUser().getLoginName();

        ShiroUtils.logout();
        return "redirect:/login.html";
    }
}
