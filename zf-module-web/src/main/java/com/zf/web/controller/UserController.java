package com.zf.web.controller;

import com.zf.dao.entity.User;
import com.zf.service.UserService;
import com.zf.utils.JWTUtils;
import com.zf.utils.TimeUtils;
import com.zf.utils.vo.APIResponse;
import com.zf.web.annotation.CheckToken;
import com.zf.web.annotation.LoginToken;
import com.zf.web.enums.WebCodeMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


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

    @Autowired
    JWTUtils jwtUtils;

    @RequestMapping("/login")
    @LoginToken
    public Object login(User user){
        try {
            User userById = userService.findUserByLogin(user.getTelephone());
            if(userById==null){return APIResponse.fail(WebCodeMsg.NOT_FOUND_USER.getCode(),
                    WebCodeMsg.NOT_FOUND_USER.getMessage());
            }else{
                if(!userById.getPassword().equals(user.getPassword())){
                    return APIResponse.fail(WebCodeMsg.USERNAME_OR_PASS_ERROR.getCode(),
                            WebCodeMsg.USERNAME_OR_PASS_ERROR.getMessage());
                }else {
                    String jwt = jwtUtils.createJWT(60000,userById.getId().toString());
                    HashMap<String,Object> map = new HashMap<>();
                    map.put("user",userById);
                    map.put("token",jwt);
                    return APIResponse.success(map);
                }
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    //查看个人信息
    @CheckToken
    @GetMapping("/getMessage")
    public APIResponse getMessage() {
        throw new RuntimeException("我是一个测试异常");
    }

}
