package com.hand.service;

import com.hand.dao.PayMentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 丁云刚 on 2018/8/25.
 */

@Service
public class PayMentService {
    @Autowired
    PayMentMapper payMentMapper;

    public void deleteEmp(Integer id) {
        short ids =   id.shortValue();
        payMentMapper.deleteByCustomer( ids );
    }
}
