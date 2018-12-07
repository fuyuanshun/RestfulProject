package com.fys.restful.service;

import com.fys.restful.model.User;

import java.util.List;

public interface UserService {
    /**
     * 用户注册
     * @param user
     */
    String addUser(User user);

    /**
     * 查询用户是否存在，如果用户存在，返回1，否则返回0
     * @param user
     * @return
     */
    int userIsExist(User user);

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    String getInfoById(String id);
}
