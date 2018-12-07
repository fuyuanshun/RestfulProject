package com.fys.restful.controller;

import com.fys.restful.model.User;
import com.fys.restful.service.AdminService;
import com.fys.restful.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getAllUserInfo(HttpServletRequest req) {
        List<User> userList = adminService.getAllUser();
        req.setAttribute("userList", userList);
        return "admin";
    }
}
