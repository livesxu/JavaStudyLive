package com.livesxu.register.service;

import com.livesxu.pojo.User;
import com.livesxu.register.dao.RegisterDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private RegisterDao registerDao;

    @Override
    public void registerUser(User user) {

        registerDao.registerUser(user);
    }
}
