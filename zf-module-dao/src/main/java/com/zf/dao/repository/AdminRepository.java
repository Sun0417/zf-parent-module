package com.zf.dao.repository;

import com.zf.dao.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 11:34
 * Description: No Description
 */
public interface AdminRepository  extends JpaRepository<Admin, Integer> {
}
