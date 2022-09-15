package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/hello")//@RequestMapping标识一个类：设置映射请求的请求路径的初始信息  也就是说 在映射前加了一层路径 /hello/tragt
public class RequestMappingController {


    @RequestMapping("/") //@RequestMapping标识一个方法：设置映射请求请求路径的具体信息
    public String index() {
        return "index";
    }


    //  restful 风格  value={"/tragt/{id}"}, method=RequestMethod.GET   一般 GET 查询  POST 增删改
    @RequestMapping(
            //value 满足其一
            value = {"/tragt","/test"},  //多个请求地址都可以响应满足其一
            //method 满足value 其一 且满足 method其一
            method =RequestMethod.GET,  //method方法  请求方式  配合value 精确匹配

            //params 中参数必须 全部满足
            params = {"username", //该请求中必须 有 username参数
                    "!username",//该请求中必须  没有 username参数
                    "username=admin",//该请求中必须 有 username参数 且 值为 admin
                    "username!=admin"//该请求中必须 有 username参数 且 值不为 admin
            },
            headers = {"header", //请求头中必须有 header 参数
                    "!header",
                    "header=XXXX",
                    "!header!=XXXX",
            }
    )
    public  String asdv(){
        return "tragt";
    }

//    @RequestMapping(   "/a?a/testAnt")//?：表示任意的单个字符
//    @RequestMapping(     "/a*a/testAnt" )// //*:表示任意的0个或多个字符
    @RequestMapping(    "/**/testAnt") //**：表示任意的一层或多层目录
    public String af(){
        return "tragt";
    }

    //SpringMVC支持路径中的占位符  路径设置变量
@RequestMapping("/testAnt/{id}/{name}")
                            //通过PathVariable("变量名")  使用
    public String na(@PathVariable("id") String id,@PathVariable("name") String name){
    System.out.println(id+"****"+name);
        return "tragt";
}

}
