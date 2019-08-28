package com.zf.dao.repository;

import com.zf.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/26
 * Time: 13:44
 * Description: No Description
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

}

