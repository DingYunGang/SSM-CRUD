package com.hand.controller;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by 丁云刚 on 2018/8/25.
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
    //    System.out.print(url+"输出地址");
        //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("name");
     //   System.out.print(username+"输出名字");

        if(url.indexOf("start.html")>=0){
          //  System.out.print("正确的");
            return true;
        }
        if(url.indexOf("login2")>=0){
            return true;
        }
        if(url.indexOf("helloworld")>=0){
            return true;
        }
        //获取Session

        if(username != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
       request.getRequestDispatcher("start.html").forward(request, response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
