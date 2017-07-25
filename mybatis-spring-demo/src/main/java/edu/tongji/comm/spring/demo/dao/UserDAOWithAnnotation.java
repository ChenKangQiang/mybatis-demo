package edu.tongji.comm.spring.demo.dao;

import edu.tongji.comm.spring.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

/**
 * Created by chen on 2017/6/29.
 * 不使用mapper xml，使用注解的形式
 * 通常注解形式没有 xml 强大
 */

@Mapper
@Component
public interface UserDAOWithAnnotation {

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getUserById(int id);

    @Insert("INSERT INTO users (username, password, email, regdata)" +
            "VALUES (#{username}, md5(#{password}), #{email}, NOW())")
    void addUser(User user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    void deleteUserById(int id);

    @Update("UPDATE users SET username = #{username}, " +
            "password = md5(#{password}), " +
            "email = #{email} " +
            "WHERE id = #{id}")
    void updateUser(User user);
}
