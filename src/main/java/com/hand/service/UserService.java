package com.hand.service;

import com.hand.dao.CustomerMapper;
import com.hand.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 丁云刚 on 2018/8/23.
 */

//用户登陆
@Service
public   class UserService {
    @Autowired
    CustomerMapper  customerMapper;


    public  List<Customer> Login(String first_name,String last_name){
        Customer c = new Customer();
        c.setFirstName(first_name);
        c.setLastName(last_name);
//        Customer customer = customerMapper.selectUser(first_name, last_name);
        List<Customer> list = customerMapper.selectUser1(c);
        return list;
    }

}
