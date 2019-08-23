package com.zf.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/23
 * Time: 14:17
 * Description: No Description
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -4320385382292396055L;

    private String userName;

    private String trueName;

    private String passWord;

    private String affiliatedGroup;




}
