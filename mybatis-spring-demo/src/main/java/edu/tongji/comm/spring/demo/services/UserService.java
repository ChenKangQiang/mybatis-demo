package edu.tongji.comm.spring.demo.services;

import edu.tongji.comm.spring.demo.dao.UserDAO;
import edu.tongji.comm.spring.demo.entity.User;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chen on 2017/6/29.
 */

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
@Component
public class UserService {

    private final Logger log = LogManager.getLogger(UserService.class);

    @Autowired
    private UserDAO userDAO;


    public void addUser(User user) {
        try {
            Validate.isTrue(user.getUsername() != null, "用户名为null");
            Validate.isTrue(user.getPassword() != null, "密码为null");
        } catch (IllegalArgumentException e) {
            log.error("参数错误", e);
        }

        userDAO.addUser(user);

        try {
            Validate.isTrue(user.getId() != null && user.getId().intValue() > 0, "用户ID为null");
        } catch (IllegalArgumentException e) {
            log.error("插入数据库失败", e);
        }
    }





    public User getUser(int id) {

        return userDAO.getUserById(id);
    }

    public int updateUser(User user) {
        return userDAO.updateUser(user);
    }

    public int deleteUser(int id) {
        return userDAO.deleteUserById(id);
    }

}
