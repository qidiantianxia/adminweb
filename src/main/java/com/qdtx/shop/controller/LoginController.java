package com.qdtx.shop.controller;

import com.qdtx.shop.dao.SysAdminMapper;
import com.qdtx.shop.pojo.ActiveAdmin;
import com.qdtx.shop.service.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yn on 2018-10-16
 */
public class LoginController {
    @Autowired
    private SysService sysService;

    //用户登录提交方法
    @RequestMapping("/login")
    public String login(HttpSession session, String randomcode, String usercode, String password) throws Exception {
        // 校验验证码，防止恶性攻击
        // 从Session中获取正确的验证码
        String validateCode = (String) session.getAttribute("validateCode");

        //输入的验证码和Session中的验证码进行对比
        if (!randomcode.equalsIgnoreCase(validateCode)) {
            //抛出异常
            throw new CustomException("验证码输入错误");
        }

        //调用Service校验用户账号和密码的正确性
        ActiveAdmin activeUser = sysService.authenticat(usercode, password);

        //如果Service校验通过，将用户身份记录到Session
        session.setAttribute("activeAdmin", activeUser);
        //重定向到商品查询页面
        return "redirect:/first.action";
    }

    //用户退出
    @RequestMapping("/logout")
    public String logout(HttpSession session) throws Exception {
        //session失效
        session.invalidate();
        //重定向到商品查询页面
        return "redirect:/first.action";
    }

}
