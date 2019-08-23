package com.zf.service;

import com.zf.dao.entity.User;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/23
 * Time: 14:34
 * Description: No Description
 */
public interface UserService {

    User selectByIdToUser(Integer id);
}
