package com.bjb.lease.common.login;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 上午1:37
 */
public class LoginUserHolder
{
    public static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        threadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return threadLocal.get();
    }

    public static void clear() {
        threadLocal.remove();
    }
}
