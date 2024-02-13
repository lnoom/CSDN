package com.yu.controller;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    /**
     * 生成验证码
     * @param request 请求对象
     * @param response 响应对象
     * @throws Exception 异常
     */
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 创建GifCaptcha对象
        GifCaptcha gifCaptcha = new GifCaptcha(130, 48, 4);
        // 输出验证码图片
        CaptchaUtil.out(gifCaptcha, request, response);
        // 获取验证码文本
        String verCode = gifCaptcha.text().toLowerCase();
        // 将验证码文本保存到session中
        request.getSession().setAttribute("CAPTCHA", verCode);
        // 打印session ID
        System.out.println(request.getSession().getId());
    }
    /**
     * 登录处理方法
     *
     * @param request  请求对象
     * @param response 响应对象
     * @return 登录结果
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("code");
        System.out.println(request.getSession().getId());
        System.out.println(request.getSession().getAttribute("CAPTCHA"));
        String sessionCode = request.getSession().getAttribute("CAPTCHA").toString();
        if (sessionCode == null || StringUtils.isEmpty(sessionCode)) {
            return "验证码为空";
        }
        if (captcha.equals(sessionCode)) {
            return "登录成功";
        }
        return "登录失败";
    }
}