package com.zf.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/26
 * Time: 13:42
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_user")
public class User  implements Serializable {
    private static final long serialVersionUID = -1631088827366485918L;

    @Id
    private Integer id;

    private String  username;

    @Column
    private String telephone;

    private String  password;


}
