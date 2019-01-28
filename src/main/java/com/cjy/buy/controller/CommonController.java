package com.cjy.buy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2019/1/25.
 */
@Controller
public class CommonController {

    @RequestMapping("/html")
    public String loginHtml(){
        return "/login";
    }

    @RequestMapping("/index")
    public String indexHtml(){
        return "/index";
    }

    @RequestMapping("/getopt")
    public String getoptHtml(){
        return "/getopt";
    }

}
