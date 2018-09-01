package com.hand.service;

import com.hand.dao.RentalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 丁云刚 on 2018/8/25.
 */

@Service
public class RentalService {

    @Autowired
    RentalMapper rentalMapper;

    public void deleteEmp(Integer id) {
        short ids =   id.shortValue();
        rentalMapper.deleteByCustomer( ids );
    }
}
