package edu.tongji.comm.spring.demo.services;


import edu.tongji.comm.spring.demo.dao.JoyFootMonthEventDAO;
import edu.tongji.comm.spring.demo.entity.JoyFootMonthEventEntity;
import edu.tongji.comm.spring.demo.request.JoyFootMonthReqDTO;
import edu.tongji.comm.spring.demo.response.JoyFootMonthRespDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class JoyEventServiceImpl implements JoyEventService {

    @Autowired
    private JoyFootMonthEventDAO joyFootMonthEventDAO;

    @Override
    public JoyFootMonthRespDTO queryJoyFootMonthByUserID(JoyFootMonthReqDTO reqDTO) {

        JoyFootMonthRespDTO respDTO = new JoyFootMonthRespDTO();

        if (reqDTO == null) {
            String eMsg = "queryJoyFootMonthByUserID 请求参数为空";
            log.error(eMsg);
            respDTO.setRespMsg(eMsg);
            return respDTO;
        }

        JoyFootMonthEventEntity entity = joyFootMonthEventDAO.queryJoyFootMonthByUserID(reqDTO.getPlatForm(), reqDTO.getUserID());

        // 记录不存在，进行弹出发券，发券信息写入数据库，并返回发券信息
        if (entity == null) {
            return addJoyFootMonthByUserID(reqDTO);
        }

        // 记录存在，从数据库中返回发券信息
        respDTO.setUserID(entity.getUserID());
        respDTO.setPlatForm(entity.getPlatForm());
        respDTO.setPlatFormCoupon(entity.getPlatFormCoupon());
        respDTO.setPlatFormCouponUsed(entity.getPlatFormCouponUsed());
        respDTO.setShop0ID(entity.getShop0ID());
        respDTO.setShop0Coupon(entity.getShop0Coupon());
        respDTO.setShop0CouponUsed(entity.getShop0CouponUsed());
        respDTO.setShop1ID(entity.getShop1ID());
        respDTO.setShop1Coupon(entity.getShop1Coupon());
        respDTO.setShop1CouponUsed(entity.getShop1CouponUsed());

        return respDTO;
    }

    @Override
    public JoyFootMonthRespDTO addJoyFootMonthByUserID(JoyFootMonthReqDTO reqDTO) {

        JoyFootMonthRespDTO respDTO = new JoyFootMonthRespDTO();
        JoyFootMonthEventEntity entity = new JoyFootMonthEventEntity();

        entity.setUserID(reqDTO.getUserID());
        /*
        添加其他属性
         */

        joyFootMonthEventDAO.insert(entity);

        return respDTO;
    }

    @Override
    public JoyFootMonthRespDTO updateJoyFootMonthCouponStatus(JoyFootMonthReqDTO reqDTO) {

        JoyFootMonthRespDTO respDTO = new JoyFootMonthRespDTO();

        if (reqDTO == null) {
            String eMsg = "updateJoyFootMonthCouponStatus 请求参数为空";
            log.error(eMsg);
            respDTO.setRespMsg(eMsg);
            return respDTO;
        }

        JoyFootMonthEventEntity entity = new JoyFootMonthEventEntity();
        entity.setUserID(reqDTO.getUserID());
        entity.setPlatFormCouponUsed(reqDTO.getPlatFormCouponUsed());
        entity.setShop0CouponUsed(reqDTO.getShop0CouponUsed());
        entity.setShop1CouponUsed(reqDTO.getShop1CouponUsed());

        int effectRows = joyFootMonthEventDAO.updateCouponStatus(entity);
        if (effectRows != 1) {
            String eMsg = "更新券信息状态失败";
            log.error(eMsg);
            respDTO.setRespMsg(eMsg);
            return respDTO;
        }

        return respDTO;
    }


}
