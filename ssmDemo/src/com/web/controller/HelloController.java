package com.web.controller;

import com.web.param.HelloParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/html")
public class HelloController {
    @RequestMapping("/sayhello.do")
    @ResponseBody
    public ModelMap printSayHello(HelloParam param) {
        System.out.println(param.getName() + "," + param.getSex());
        ModelMap model = new ModelMap();
        model.addAttribute("msg", param.getName() + "你是一名 SSM 实践者!");
        return model;
    }
}