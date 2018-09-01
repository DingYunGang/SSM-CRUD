package com.hand.controller;

import com.hand.dto.Customer;
import com.hand.dto.Msg;
import com.hand.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 丁云刚 on 2018/8/23.
 */

@Controller
public class Login {
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping(value = "/login2")
    public Msg login(
           @RequestParam("firstName")String firstName,
           @RequestParam("lastName")String lastName,
           HttpSession session) {
     List<Customer> list = userService.Login(firstName, lastName);

       if(list.size()<1){
           //登陆失败
           System.out.print("登陆失败"+firstName+"  "+lastName);
           return Msg.fail();
       }else{
           //登陆成功
           System.out.print("登陆成功: "+list.get(0).getFirstName() + "  " + list.get(0).getLastName());
           return Msg.success().add("rigth",list.get(0));
       }
    }
}
