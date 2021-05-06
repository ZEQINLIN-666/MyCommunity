package com.zeqinlin.MyCommunity.controller;

import com.zeqinlin.MyCommunity.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * date: 2021/5/2 17:29
 *
 * @author dell Linzeqin
 * @since JDK 1.8
 */

@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot";
    }

    @RequestMapping("/data")
    @ResponseBody
    public String data(){
        return alphaService.find();
    }

    @RequestMapping("http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name +":"+ value);
        }

        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");

        try (PrintWriter writer = response.getWriter()){    //自动生成finally，并执行writer.close();
            writer.write("<h1>我的社区</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * GET请求
     */
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String get(@RequestParam(name = "current",required = false,defaultValue = "1") int current,
                    @RequestParam(name = "limit",required = false,defaultValue = "10") int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    /**
     * 从路径中获取参数 利用@PathVariable()注解
     */
    @RequestMapping(path = "/students/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable(name = "id") int id){
        System.out.println(id);
        return "a student";
    }

    /**
     * POST请求用于提交数据
     */
    @RequestMapping(path = "/student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,int age){
        System.out.println(name);
        System.out.println(age);
        return "Save success";
    }
    /**
     * 响应html数据，即一个网页的形式 两种方式
     */
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","zhangsan");
        modelAndView.addObject("age","30");
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }
    //方式2
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","北京大学");
        model.addAttribute("age","100");
        return "/demo/view";
    }

    //响应JSON数据（异步请求）
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","张三");
        map.put("age",25);
        map.put("salary",10000.00);
        return map;
    }
}
