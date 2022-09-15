package com.mvc.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class ScopeController {

    //使用ServletAPI向request域对象共享数据
    @RequestMapping(value = "/textRequestByServletAPI")
    public String textRequestByServletAPI(HttpServletRequest re) {
        re.setAttribute("requestscope", "原生APIrequest");
        HttpSession session = re.getSession();
        ////使用ServletAPI向session域对象共享数据
        session.setAttribute("sessionscope", "原生APIsession");
        ServletContext servletContext = re.getServletContext();
        //使用ServletAPI向application域对象共享数据
        servletContext.setAttribute("application", "原生API application ");
        return "tragt";
    }


    //使用ModelAndView向request域对象共享数据
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        /**
         * ModelAndView有Model和View的功能
         * Model主要用于向请求域共享数据
         * View主要用于设置视图，实现页面跳转
         */
        ModelAndView mav = new ModelAndView();
        //处理模型数据，即向请求域共享数据
        mav.addObject("requestscope", "hello,ModelAndView");
        //设置视图名称，实现页面跳转
        mav.setViewName("tragt");
        return mav;
    }

    //使用Model向request域对象共享数据
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        model.addAttribute("requestscope", "hello,Model");
        return "tragt";
    }


    //使用map向request域对象共享数据
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        map.put("requestscope", "hello,Map");
        return "tragt";
    }

    //使用ModelMap向request域对象共享数据
    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("requestscope", "hello,ModelMap");
        return "tragt";
    }

}
