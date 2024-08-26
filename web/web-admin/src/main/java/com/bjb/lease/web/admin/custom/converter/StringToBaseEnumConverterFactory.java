package com.bjb.lease.web.admin.custom.converter;

import com.bjb.lease.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/2 下午7:32
 */
@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum>
{
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType)
    {
        return new Converter<String, T>()
        {
            @Override
            public T convert(String code)
            {
                T[] enumConstants = targetType.getEnumConstants();
                for(T enumConstant : enumConstants)
                {
                    if(enumConstant.getCode().equals(Integer.valueOf(code)))
                        return enumConstant;
                }
                throw new IllegalArgumentException("code: " + code + "非法");
            }
        };
    }
}
