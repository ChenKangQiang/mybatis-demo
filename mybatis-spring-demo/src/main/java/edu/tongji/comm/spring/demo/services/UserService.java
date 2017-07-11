package edu.tongji.comm.spring.demo.services;

import edu.tongji.comm.spring.demo.dao.UserMapper;
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
    private UserMapper userMapper;

    public void addUser(User user) {
        log.info("向数据库增加用户记录");
        userMapper.addUser(user);
    }

    public User getUser(int id) {

        return userMapper.getUserById(id);
    }

    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    public int deleteUser(int id) {
        return userMapper.deleteUserById(id);
    }

}
