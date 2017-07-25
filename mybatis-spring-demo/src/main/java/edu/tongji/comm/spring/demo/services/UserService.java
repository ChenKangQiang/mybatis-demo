package edu.tongji.comm.spring.demo.services;

import edu.tongji.comm.spring.demo.dao.UserDAO;
import edu.tongji.comm.spring.demo.entity.User;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public void addUser(User user) {
        log.info("向数据库增加用户记录");
        userDAO.addUser(user);
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
