package com.zf.web.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/29
 * Time: 15:48
 * Description: No Description
 */
@Getter
public enum  WebCodeMsg {
    NOT_FOUND_USER(101, "用户不存在"),
    USERNAME_OR_PASS_ERROR(102, "手机号或者密码错误");

    private Integer code;
    private String message;

    WebCodeMsg(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

