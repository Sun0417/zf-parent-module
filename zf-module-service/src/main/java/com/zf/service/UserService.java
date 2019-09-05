package com.zf.service;


import com.zf.dao.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/26
 * Time: 13:49
 * Description: No Description
 */
@Repository
public interface UserService {

    User findUserById(Integer id);

    User findUserByLogin(String tel);
}
