package edu.tongji.comm.spring.demo.services;


import edu.tongji.comm.spring.demo.request.JoyFootMonthReqDTO;
import edu.tongji.comm.spring.demo.request.JoyFootMonthUpdateReqDTO;
import edu.tongji.comm.spring.demo.response.JoyFootMonthRespDTO;

public interface JoyEventService {


    /**
     * 根据用户ID查询用户发券信息
     *
     * @param reqDTO
     * @return
     */
    JoyFootMonthRespDTO queryJoyFootMonthByUserID(JoyFootMonthReqDTO reqDTO);

    /**
     * 添加用户发券信息
     *
     * @param reqDTO
     * @return
     */
    JoyFootMonthRespDTO addJoyFootMonthByUserID(JoyFootMonthReqDTO reqDTO);

    /**
     * 更新用户券的使用状态
     *
     * @param reqDTO
     * @return
     */
    JoyFootMonthRespDTO updateJoyFootMonthCouponStatus(JoyFootMonthUpdateReqDTO reqDTO);
}
