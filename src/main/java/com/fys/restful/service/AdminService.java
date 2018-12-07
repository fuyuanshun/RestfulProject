package com.fys.restful.service;

import com.fys.restful.model.User;

import java.util.List;

public interface AdminService {
    /**
     * 获取所有的用户信息
     * @return
     */
    List<User> getAllUser();
}
