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
 * Time: 11:51
 * Description: No Description
 */
@Data
@Entity
@Table(name="zf_obligor")
public class Borrower implements Serializable {
    private static final long serialVersionUID = -862180211115395782L;

    @Id
    private Integer id;
}
