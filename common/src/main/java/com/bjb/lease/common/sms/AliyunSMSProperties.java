package com.bjb.lease.common.sms;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/7 上午10:58
 */
@Data
@ConfigurationProperties(prefix = "aliyun.sms")
public class AliyunSMSProperties
{
    private String accessKeyId;

    private String accessKeySecret;

    private String endpoint;
}
