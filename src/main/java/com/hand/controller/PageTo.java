package com.hand.controller;

/**
 * Created by 丁云刚 on 2018/8/25.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
//用户的登陆和退出
@Controller
public class PageTo {

    @RequestMapping("/helloworld")
    public String hello(@RequestParam("id")String id,HttpSession session){

       // System.out.println("hello world  这是id "+id);
       // System.out.println("进入控制器");
        session.setAttribute("name",id);
        return "index";
    }
    @RequestMapping(value="/logout")
    public ModelAndView logout(HttpSession session) throws Exception{
        //清除Session
        session.invalidate();
        return new ModelAndView("redirect:/start.html");
    }

}
