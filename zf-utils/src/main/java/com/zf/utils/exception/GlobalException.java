package com.zf.utils.exception;

import com.zf.utils.enums.CodeMsgEnum;
import com.zf.utils.vo.APIResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/29
 * Time: 16:12
 * Description: No Description
 */
@ControllerAdvice
public class GlobalException extends RuntimeException {

    @ExceptionHandler
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public APIResponse exceptionHandler(Exception e) {
        String error = e.getMessage();
        Integer code = CodeMsgEnum.FAIL.getCode();
        return APIResponse.fail(code,error);
    }
}
