package edu.tongji.comm.spring.demo.dao;

import edu.tongji.comm.spring.demo.entity.JoyFootMonthEventEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by chen on 2017/7/10.
 */

@Repository
public interface JoyFootMonthEventDAO {

    JoyFootMonthEventEntity queryJoyFootMonthByUserID(@Param("platForm") Integer platForm, @Param("userID") Long userID);

    void insert(@Param("entity") JoyFootMonthEventEntity entity);

    int updateCouponStatus(@Param("entity") JoyFootMonthEventEntity entity);

}
