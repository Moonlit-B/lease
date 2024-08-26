package com.bjb.lease.web.admin.service;

import com.bjb.lease.web.admin.vo.login.CaptchaVo;
import com.bjb.lease.web.admin.vo.login.LoginVo;
import com.bjb.lease.web.admin.vo.system.user.SystemUserInfoVo;

public interface LoginService {

    CaptchaVo getCaptcha();

    String login(LoginVo loginVo);

    SystemUserInfoVo getLoginUserInfoById(long userId);
}
