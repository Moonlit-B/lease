package com.bjb.lease.common.login;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 上午1:37
 */
@Data
@AllArgsConstructor
public class LoginUser {

    private Long userId;
    private String username;
}
