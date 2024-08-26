package com.bjb.lease.common.utils;

import com.bjb.lease.common.exception.LeaseException;
import com.bjb.lease.common.result.ResultCodeEnum;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;


import javax.crypto.SecretKey;
import java.util.Date;

/**
 * @author Bi
 * @version 1.0
 * @date 2024/8/6 下午9:29
 */
public class JwtUtil {

    private static long tokenExpiration = 60 * 60 * 1000L;
    private static SecretKey tokenSignKey = Keys.hmacShaKeyFor("MGRy8GUfKmub2aVHMA7HS6NQuUJHrDRg".getBytes());

    public static String createToken(Long userId, String username)
    {

        String token = Jwts.builder().
                    setSubject("USER_INFO").
                    setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)).
                    claim("userId", userId).
                    claim("username", username).
                    signWith(tokenSignKey, SignatureAlgorithm.HS256).
                    compact();
        return token;
    }

    public static Claims parseToken(String token)
    {
        if(token == null)
        {
            throw new LeaseException(ResultCodeEnum.ADMIN_LOGIN_AUTH);
        }

        try
        {
            JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(tokenSignKey).build();
            Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);
            return claimsJws.getBody();
        } catch(ExpiredJwtException e)
        {
            throw new LeaseException(ResultCodeEnum.TOKEN_EXPIRED);
        } catch(JwtException e)
        {
            throw new LeaseException(ResultCodeEnum.TOKEN_INVALID);
        }
    }

    public static void main(String[] args)
    {
        System.out.println(createToken(8L, "18093984137"));
    }
}
