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
 * Time: 11:44
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_balance_record")
public class BalanceRecord implements Serializable {
    private static final long serialVersionUID = -6981188047794394949L;

    @Id
    private Integer id;
}
