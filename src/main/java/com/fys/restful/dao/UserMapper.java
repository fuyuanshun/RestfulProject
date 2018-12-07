package com.fys.restful.dao;

import com.fys.restful.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    /**
     * 用户注册
     * @param user
     */
    int addUser(User user);

    /**
     * 查询用户是否存在，如果用户存在，返回1，否则返回0
     * @param user
     * @return
     */
    int userIsExist(User user);

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    User getInfoById(String id);

    /**
     * 获取所有的用户信息
     * @return
     */
   List<User> getUserList();
}
