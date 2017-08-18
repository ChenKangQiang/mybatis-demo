package edu.tongji.comm.spring.demo.dao;

import edu.tongji.comm.spring.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by chen on 2017/6/29.
 */

// 必须配置@component或者@Repository，这样spring才能识别该Bean
@Component
public interface UserDAO {

    User getUserById(int id);

    int addUser(User user);

    int ignoreInsert(User user);

    int ignoreInsertNew(User user);


    int insertUser2(User user);

    int insertUser1(User user);

    int deleteUserById(int id);

    int updateUser(User user);

    // 多输入参数，使用 @Param 注解
    List<User> getUsers(@Param("start") int start, @Param("end") int end);

}
