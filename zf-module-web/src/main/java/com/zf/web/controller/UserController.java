package com.zf.web.controller;

import com.zf.dao.entity.User;
import com.zf.service.UserService;
import com.zf.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/26
 * Time: 14:03
 * Description: No Description
 */
@RequestMapping("/web-api")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    TimeUtils timeUtils;

    @RequestMapping("/user/list")
    public User userList(){
        Integer id = 1;
        String times = timeUtils.getTime();
        System.out.println(times);
        return userService.selectUserList(id);
    }


}
