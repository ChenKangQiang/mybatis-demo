package edu.tongji.comm.typical.demo.mappers;

import com.oracle.jrockit.jfr.UseConstantPool;
import edu.tongji.comm.typical.demo.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * Created by chen on 2017/6/29.
 * 不使用mapper xml，使用注解的形式
 */
@Mapper
public interface UserMapperWithAnnotation {

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
