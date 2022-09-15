package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.http.HttpServletRequest;


@Controller
public class TestController {

    @RequestMapping("/param")
    public String a() {

        return "test_param";

    }

    //原生serverletAPI 获取请求参数
    @RequestMapping("/one") //@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
    public String index(HttpServletRequest resquest) {
        String name = resquest.getParameter("name");
        String age = resquest.getParameter("age");
        System.out.println(name + "-----------" + age);
        return "tragt";
    }

    //通过控制器方法的形参获取请求参数
    @RequestMapping("/two")
    public String two(
            @RequestParam(value = "nameasd",//@RequestParam 指定请求参数 与形参绑定赋值
                    required = false,// required = false 自动装配失败 赋值bull
                    defaultValue = "defo"//defaultValue 没有获取到数值或者没有获取到变量名 则形参为默认值
            ) String name,
            String age,
            String hobby,
            @RequestHeader("Host") String host,
            @CookieValue("JSESSION") String JSESSION
            ) {
        //形参名和页面变量名一样即可获取请求参数
        //若同名形参有多个值，可以用字符串获取 也可以用数组获取

        System.out.println(name + "-----------" + age + "-----" + hobby+"----"+host);
        return "tragt";
    }

    @RequestMapping("/three")
    public String three(User user){
        System.out.println(user);

        return  "tragt";
    }

}
