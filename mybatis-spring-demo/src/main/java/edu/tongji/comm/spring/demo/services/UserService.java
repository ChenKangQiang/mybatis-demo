package edu.tongji.comm.spring.demo.services;

import edu.tongji.comm.spring.demo.domain.User;
import edu.tongji.comm.spring.demo.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by chen on 2017/6/29.
 */

@Component
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
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
