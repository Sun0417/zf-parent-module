package com.zf.web.controller;

import com.zf.dao.entity.User;
import com.zf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/23
 * Time: 15:44
 * Description: No Description
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public User userList(){
        Integer id = 1;
        return userService.selectByIdToUser(id);
    }

}
