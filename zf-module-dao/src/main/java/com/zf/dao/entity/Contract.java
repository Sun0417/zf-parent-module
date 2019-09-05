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
 * Time: 11:48
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_contract")
public class Contract implements Serializable {
    private static final long serialVersionUID = 6059128809031935266L;

    @Id
    private Integer id;
}
