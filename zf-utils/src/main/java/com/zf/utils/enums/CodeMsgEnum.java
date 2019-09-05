package com.zf.utils.enums;

import lombok.Getter;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/29
 * Time: 15:15
 * Description: No Description
 */
@Getter
public enum CodeMsgEnum {

    SUCCESS(200, "success"),
    FAIL(400, "failed");

    private Integer code;
    private String message;

    CodeMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
