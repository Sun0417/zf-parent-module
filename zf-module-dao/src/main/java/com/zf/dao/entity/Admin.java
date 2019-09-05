package com.zf.dao.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 11:33
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_admin")
public class Admin implements Serializable {
    private static final long serialVersionUID = -4333208551197008217L;

    @Id
    private Integer id;

    private String username;
}
