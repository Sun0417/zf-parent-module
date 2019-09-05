package com.zf.dao.repository;

import com.zf.dao.entity.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 11:53
 * Description: No Description
 */
public interface BorrowerRepository extends JpaRepository<Borrower , Integer> {
}
