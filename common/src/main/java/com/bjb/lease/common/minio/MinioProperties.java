package com.bjb.lease.common.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/4 下午3:30
 */
@Data
@ConfigurationProperties(prefix = "minio")
public class MinioProperties
{
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucketName;
}
