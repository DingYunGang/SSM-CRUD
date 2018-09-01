package com.hand.dao;

import com.hand.dto.PayMent;
import com.hand.dto.PayMentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayMentMapper {
    long countByExample(PayMentExample example);

    int deleteByExample(PayMentExample example);

    int deleteByPrimaryKey(Short paymentId);

    int deleteByCustomer(Short paymentId);

    int insert(PayMent record);

    int insertSelective(PayMent record);

    List<PayMent> selectByExample(PayMentExample example);

    PayMent selectByPrimaryKey(Short paymentId);

    int updateByExampleSelective(@Param("record") PayMent record, @Param("example") PayMentExample example);

    int updateByExample(@Param("record") PayMent record, @Param("example") PayMentExample example);

    int updateByPrimaryKeySelective(PayMent record);

    int updateByPrimaryKey(PayMent record);
}