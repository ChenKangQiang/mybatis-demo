package edu.tongji.comm.spring.demo.response;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jiabincheng on 17/7/10.
 */

@Data
public class JoyFootMonthRespDTO implements Serializable {
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

    private String respMsg;
}
