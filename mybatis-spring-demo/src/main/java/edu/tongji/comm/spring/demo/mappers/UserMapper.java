package edu.tongji.comm.spring.demo.mappers;

import edu.tongji.comm.spring.demo.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by chen on 2017/6/29.
 */

// 必须配置@component，这样spring才能识别该Bean
@Component
public interface UserMapper {

    User getUserById(int id);

    int addUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

}
