package com.zf.serviceimpl.Impl;

import com.zf.dao.entity.User;
import com.zf.dao.repository.UserRepository;
import com.zf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/26
 * Time: 13:58
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User findUserByLogin(String tel) {
        return userRepository.findUserByTelephone(tel);
    }
}
