package com.hand.service;

import com.hand.dao.CustomerMapper;
import com.hand.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 丁云刚 on 2018/8/22.
 */


@Service
public class CustomerService {

    @Autowired
    CustomerMapper  customerMapper;

    /**
     * 查询所有顾客
     * @return
     */

    public List<Customer> getAll() {
        // TODO Auto-generated method stub
        return customerMapper.selectByExampleWithAddress(null);
    }

    public void saveEmp(Customer customer) {
        customerMapper.insertSelective(customer);
    }

    public void deleteEmp(Integer id) {
        short ids =   id.shortValue();
        customerMapper.deleteByPrimaryKey( ids );
    }

    public void updateEmp(Customer customer) {
        customerMapper.updateByPrimaryKeySelective(customer);
    }
}
