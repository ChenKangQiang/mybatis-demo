package edu.tongji.comm.typical.demo.mappers;

import edu.tongji.comm.typical.demo.domain.User;

/**
 * Created by chen on 2017/6/29.
 */
public interface UserMapper {

    User getUserById(int id);

    void addUser(User user);

    void deleteUserById(int id);

    void updateUser(User user);

}
