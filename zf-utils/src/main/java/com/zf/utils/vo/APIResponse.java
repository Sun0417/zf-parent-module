package com.zf.utils.vo;

import com.zf.utils.enums.CodeMsgEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/29
 * Time: 14:27
 * Description: No Description
 */
@Data
public class APIResponse<T> implements Serializable {

    private static final long serialVersionUID = -819214336217043527L;

    private Integer code;

    private String msg;

    private T data;


    public APIResponse(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public APIResponse(CodeMsgEnum codeMsgEnum){
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMessage();
    }

    public APIResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public APIResponse(CodeMsgEnum codeMsgEnum, T data) {
        this.code = codeMsgEnum.getCode();
        this.msg = codeMsgEnum.getMessage();
        this.data = data;
    }

    public APIResponse(){}

    /**
     * 正常返回
     * @param <T>
     * @return
     */
    public  static <T> APIResponse<T> success(){
        return new APIResponse<>(CodeMsgEnum.SUCCESS);
    }

    /**
     * 正常返回带数据
     * @param data
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> success(T data){
        return new APIResponse<>(CodeMsgEnum.SUCCESS, data);
    }

    /**
     * 自定义状态码和数据
     * @param code
     * @param msg
     * @param data
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> success(Integer code, String msg, T data){
        return new APIResponse<>(code, msg, data);
    }

    /**
     * 错误返回
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> fail(){
        return new APIResponse<>(CodeMsgEnum.FAIL);
    }

    /**
     * 自定义错误信息
     * @param code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> APIResponse<T> fail(Integer code, String msg){
        return new APIResponse<>(code, msg);
    }

}
