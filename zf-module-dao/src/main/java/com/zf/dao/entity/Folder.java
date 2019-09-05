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
 * Time: 11:46
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_folder")
public class Folder implements Serializable {
    private static final long serialVersionUID = 1712988231937003493L;

    @Id
    private Integer id;
}
