package com.fys.restful.service.impl;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fys.restful.dao.UserMapper;
import com.fys.restful.model.User;
import com.fys.restful.service.UserService;
import com.fys.restful.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userDao;

    @Override
    public String addUser(User user) {
        ResultUtil resultUtil;
        if ("".equals(user.getUsername()) || "".equals(user.getEmail())) {
            resultUtil = new ResultUtil("400", "信息不能为空", null);
            return JSON.toJSONString(resultUtil);
        }

        if (userIsExist(user) > 0) {
            resultUtil = new ResultUtil("400", "用户已经存在", null);
            return JSON.toJSONString(resultUtil);
        }
        if (userDao.addUser(user) > 0) {
            resultUtil = new ResultUtil("200", "注册成功", null);
            return JSON.toJSONString(resultUtil);
        } else {
            resultUtil = new ResultUtil("400", "注册失败", null);
            return JSON.toJSONString(resultUtil);
        }
    }

    /**
     * 查询用户是否存在，如果用户存在，返回1，否则返回0
     * @param user
     * @return
     */
    @Override
    public int userIsExist(User user) {
        return userDao.userIsExist(user);
    }


    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    @Override
    public String getInfoById(String id) {
        ResultUtil resultUtil;
        if (null != id && !id.equals("")) {
            User user = userDao.getInfoById(id);
            resultUtil = new ResultUtil("200", "查询成功", user);
            return JSON.toJSONString(resultUtil);
        }
        resultUtil = new ResultUtil("400", "id不能为空", null);
        return JSON.toJSONString(resultUtil);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @Override
    public String deleteUser(String id) {
        ResultUtil resultUtil;
        if (null != id && !id.equals("") && id.matches("^\\d+$")) {
            int i = userDao.deleteUser(id);
            if (i == 0) {
                resultUtil = new ResultUtil("406", "没有找到对应id的用户", null);
                return JSON.toJSONString(resultUtil);
            }
            resultUtil = new ResultUtil("200", "删除成功", null);
            return JSON.toJSONString(resultUtil);
        }
        resultUtil = new ResultUtil("200", "id只能为数字", null);

        return JSON.toJSONString(resultUtil);
    }
}
