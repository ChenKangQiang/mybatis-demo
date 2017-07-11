package edu.tongji.comm.spring.demo.request;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by jiabincheng on 17/7/10.
 */

@Data
public class JoyFootMonthReqDTO implements Serializable {
    protected Integer userID;
    protected Integer platform;
}
