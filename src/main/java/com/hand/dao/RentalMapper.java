package com.hand.dao;

import com.hand.dto.Rental;
import com.hand.dto.RentalExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentalMapper {
    long countByExample(RentalExample example);

    int deleteByExample(RentalExample example);

    int deleteByPrimaryKey(Integer rentalId);

    int insert(Rental record);

    int insertSelective(Rental record);

    List<Rental> selectByExample(RentalExample example);

    Rental selectByPrimaryKey(Integer rentalId);

    int updateByExampleSelective(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByExample(@Param("record") Rental record, @Param("example") RentalExample example);

    int updateByPrimaryKeySelective(Rental record);

    int updateByPrimaryKey(Rental record);

    int deleteByCustomer(short rentalId);
}