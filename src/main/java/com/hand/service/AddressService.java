package com.hand.service;

import com.hand.dao.AddressMapper;
import com.hand.dto.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 丁云刚 on 2018/8/24.
 */

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;
    public List<Address> getAdd  (){
        List<Address> list = addressMapper.selectByExample(null);
        return list;
    }
}
