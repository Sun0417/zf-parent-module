package com.zf.dao.entity;

import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 11:39
 * Description: No Description
 */
@Data
@Entity
@Table(name = "zf_apply_image")
public class ApplyImage implements Serializable {
    private static final long serialVersionUID = -7509240817018981904L;

    @Id
    private Integer id;
}
