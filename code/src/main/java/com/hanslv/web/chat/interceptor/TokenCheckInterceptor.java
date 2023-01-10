package com.hanslv.web.chat.interceptor;

import com.hanslv.web.chat.constants.HeaderConstants;
import com.hanslv.web.chat.handler.TokenHandler;
import com.hanslv.web.chat.interfaces.TokenCheck;
import com.hanslv.web.chat.util.StringUtils;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/6 10:42
 * @description Token校验拦截器
 */
@Slf4j
@Component
public class TokenCheckInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenHandler tokenHandler;

    /**
     * 前拦截
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器
     * @return 是否通过
     */
    @Override
    public boolean preHandle(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @NonNull Object handler){
        // 判断是否需要Token校验
        TokenCheck tokenCheck;
        // 区别于静态资源请求
        if(handler instanceof HandlerMethod){
            tokenCheck = ((HandlerMethod) handler).getMethodAnnotation(TokenCheck.class);
        }else{
            return true;
        }
        if(tokenCheck == null){
            return true;
        }
        // 获取请求中的Token
        String token = request.getHeader(HeaderConstants.TOKEN);
        // 获取请求中的UserId
        String userId = request.getHeader(HeaderConstants.USER_ID);
        if(!StringUtils.isEmpty(userId) && !StringUtils.isEmpty(token)){
            // 进行Token校验
            return tokenHandler.tokenCheck(Integer.parseInt(userId), token);
        }
        // 校验失败进行拦截
        return false;
    }
}
