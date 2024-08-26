package com.bjb.lease.common.exception;

import com.bjb.lease.common.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/5 上午10:31
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result handle(Exception e)
    {
        e.printStackTrace();
        return Result.fail();
    }

    @ExceptionHandler(LeaseException.class)
    @ResponseBody
    public Result handle(LeaseException e)
    {
        e.printStackTrace();
        return Result.fail(e.getCode(), e.getMessage());
    }
}
