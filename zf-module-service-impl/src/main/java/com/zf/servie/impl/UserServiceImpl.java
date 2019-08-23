package com.zf.servie.impl;

import com.zf.dao.entity.User;
import com.zf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/23
 * Time: 14:41
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Override
    public User selectByIdToUser(Integer id) {
        return userRepository.findById(id).get();
    }
}
