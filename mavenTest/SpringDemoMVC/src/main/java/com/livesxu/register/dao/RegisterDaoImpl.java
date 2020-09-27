package com.livesxu.register.dao;

import com.livesxu.mapper.UserMapper;
import com.livesxu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDaoImpl implements RegisterDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {

        userMapper.insert(user);
    }
}
