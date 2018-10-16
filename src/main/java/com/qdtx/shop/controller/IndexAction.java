package com.qdtx.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yn on 2018-10-16
 */
@Controller
public class IndexAction {
    //系统首页
    @RequestMapping("/first")
    public String first(Model model)throws Exception{

        return "/first";
    }

    //欢迎页面
    @RequestMapping("/welcome")
    public String welcome(Model model)throws Exception{

        return "/welcome.jsp";

    }
}
