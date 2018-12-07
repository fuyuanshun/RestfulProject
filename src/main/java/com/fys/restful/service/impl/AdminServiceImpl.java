package com.fys.restful.service.impl;

import com.fys.restful.dao.UserMapper;
import com.fys.restful.model.User;
import com.fys.restful.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userDao;

    /**
     * 获取所有的用户信息
     * @return
     */
    @Override
    public List<User> getAllUser() {
        return userDao.getUserList();
    }
}
