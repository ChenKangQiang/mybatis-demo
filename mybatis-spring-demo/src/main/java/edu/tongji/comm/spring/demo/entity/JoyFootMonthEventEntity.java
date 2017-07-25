package edu.tongji.comm.spring.demo.entity;

import lombok.Data;

/**
 * Created by chen on 2017/7/10.
 */

@Data
public class JoyFootMonthEventEntity {
    private Integer platForm;
    private Long userID;
    private Integer platFormCoupon;
    private Integer platFormCouponUsed;
    private Integer shop0ID;
    private Integer shop0Coupon;
    private Integer shop0CouponUsed;
    private Integer shop1ID;
    private Integer shop1Coupon;
    private Integer shop1CouponUsed;
}
