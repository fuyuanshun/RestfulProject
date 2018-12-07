package com.fys.restful.controller;

import com.fys.restful.model.User;
import com.fys.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user 用户信息
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody String test(User user) {
        return userService.addUser(user);
    }

    /**
     * 查询用户信息
     * @param id 用户id
     * @return
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public @ResponseBody
    String getInfo(@PathVariable String id) {
        return userService.getInfoById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody String deleteUser(@PathVariable String id) {
        return "";
    }
}
