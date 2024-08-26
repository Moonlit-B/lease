package com.bjb.lease.web.admin.custom.interceptor;

import com.bjb.lease.common.exception.LeaseException;
import com.bjb.lease.common.login.LoginUser;
import com.bjb.lease.common.login.LoginUserHolder;
import com.bjb.lease.common.result.ResultCodeEnum;
import com.bjb.lease.common.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 上午1:00
 */
@Component
public class AuthenticationInterceptor implements HandlerInterceptor
{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception
    {
        String token = request.getHeader("access-token");

        Claims claims = JwtUtil.parseToken(token);
        Long userId = claims.get("userId", Long.class);
        String username = claims.get("username", String.class);
        LoginUserHolder.setLoginUser(new LoginUser(userId, username));

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception
    {
        LoginUserHolder.clear();
    }
}
