package com.bjb.lease.common.utils;

import java.util.Random;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 下午2:57
 */
public class CodeUtil
{
    public static String getVerifyCode(int length)
    {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++)
        {
            builder.append(random.nextInt(10));
        }
        return builder.toString();
    }
}
