package com.hand.controller;

import com.hand.dto.Address;
import com.hand.dto.Msg;
import com.hand.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by 丁云刚 on 2018/8/24.
 */

@Controller
public class AddressController {
  @Autowired
    AddressService addressService;

  @RequestMapping("/depts")
  @ResponseBody
  public Msg getAdd(){
      List<Address> list =  addressService.getAdd();
      return Msg.success().add("depts",list);
  }
}
