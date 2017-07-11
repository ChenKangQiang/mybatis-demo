package edu.tongji.comm.spring.demo.request;

import lombok.Data;

/**
 * Created by chen on 2017/7/11.
 */

@Data
public class JoyFootMonthUpdateReqDTO extends JoyFootMonthReqDTO {
    private Integer platformCouponUsed;
    private Integer shop0CouponUsed;
    private Integer shop1CouponUsed;
}
