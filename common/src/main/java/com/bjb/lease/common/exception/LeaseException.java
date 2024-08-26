package com.bjb.lease.common.exception;
import com.bjb.lease.common.result.ResultCodeEnum;
import lombok.Data;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/5 下午4:23
 */
@Data
public class LeaseException extends RuntimeException
{
    private Integer code;

    public LeaseException(Integer code, String message)
    {
        super(message);
        this.code = code;
    }

    public LeaseException(ResultCodeEnum resultCodeEnum)
    {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }
}
