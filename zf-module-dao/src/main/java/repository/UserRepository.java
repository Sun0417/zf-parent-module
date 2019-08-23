package repository;

import com.zf.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/23
 * Time: 14:24
 * Description: No Description
 */

/**
 *  继承JpaRepository来完成对数据库表的操作
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
