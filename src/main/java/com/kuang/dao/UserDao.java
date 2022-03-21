package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

/**
 * @author Huang.learning 2022/3/19 8:53
 */
public interface UserDao {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int removeUser(int id);
}