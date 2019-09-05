package com.zf.web.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.zf.dao.entity.User;
import com.zf.service.UserService;
import com.zf.utils.JWTUtils;
import com.zf.web.annotation.CheckToken;
import com.zf.web.annotation.LoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * 拦截器
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 16:47
 * Description: No Description
 */
@Component
public class AuthenticationInterceptor  implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Autowired
    JWTUtils jwtUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从http请求头中取出token
        String token = request.getHeader("token");

        //如果不是映射到方法直接通过
        if(!(handler instanceof HandlerMethod)){return  false;}

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查是否有loginToken的注解 有则跳过认证
        if(method.isAnnotationPresent(LoginToken.class)){
            //获取loginToken注解
            LoginToken loginToken = method.getAnnotation(LoginToken.class);
            if(loginToken.required()){return  true;}
        }
        //检查有没有需要用户权限的注解
        if(method.isAnnotationPresent(CheckToken.class)){

            CheckToken checkToken = method.getAnnotation(CheckToken.class);

            if(checkToken.required()){
                //执行认证
                if(token==null){
                    throw new RuntimeException("无token，请重新登录");
                }
                String userId;
                try {
                    userId = JWT.decode(token).getSubject();
                    User user = userService.findUserById(new Integer(userId));
                    if(user==null){throw new RuntimeException("用户不存在，请重新登录");}

                }catch (JWTDecodeException j){
                    throw new RuntimeException("访问异常！");
                }

                Boolean verify = jwtUtils.isVerify(token, userId);
                if(!verify){
                    throw  new RuntimeException("非法访问！");
                }

                return true;
            }
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
