package com.mvc.controller;

import com.mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller

@RestController //@Controller注解，并且为其中的每个方法添加了@ResponseBody注解
public class RequsetBody {

    //@RequestBody 获取请求体信息

    @RequestMapping("/RequsetBody")
    public  String RequsetBodytest(@RequestBody String requset){

        System.out.println(requset);
        return  "index";
    }
    //RequestEntity 将请求报文封装成 实体  该实体中包含请求一切信息
    @RequestMapping("/RequestEntity")
    public  String RequestEntity(RequestEntity<String>  requestEntity){

        System.out.println(requestEntity.getBody());//获取请求体信息
        System.out.println(requestEntity.getMethod());//请求方式
        System.out.println(requestEntity.getHeaders());//请求头
        return "index";
    }

    @RequestMapping("/ResponseBody")
    @ResponseBody  //响应体
    public User ResponseBody(){
    return  new User("张三",16);
    }


//ResponseEntity用于控制器方法的返回值类型，该控制器方法的返回值就是响应到浏览器的响应报文
    //自定义的 响应报文  例如 文件下载














}
