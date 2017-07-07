package edu.tongji.comm.spring.demo.mappers;

import edu.tongji.comm.spring.demo.domain.User;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by chen on 2017/6/29.
 */

// 必须配置@component，这样spring才能识别该Bean
@Component
public interface UserMapper {

    User getUserById(int id);

    int addUser(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    // 多输入参数，使用 @Param 注解
    List<User> getUsers(@Param("start") int start, @Param("end")int end);

}
