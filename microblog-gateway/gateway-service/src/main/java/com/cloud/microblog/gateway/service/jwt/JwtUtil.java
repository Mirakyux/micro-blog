package com.cloud.microblog.gateway.service.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JwtUtil {
    // 过期时间5分钟
    private static final long EXPIRE_TIME = 10 * 1000;

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);

            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {

        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);

    }

    public static void main(String args[]){

        String user = "liang";
        String password = "123456";

        String token = JwtUtil.sign(user,password);
        log.debug("token = {}",token);
        /*** 头信息、有效载荷、签名
         eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9
         .eyJleHAiOjE1NTA4NDQxNjYsInVzZXJuYW1lIjoibGlhbmcifQ
         .marifGLxrAShTx8UHABaoc693v5j2Ai9TTUyz4jABu0
       */

        String getName = JwtUtil.getUsername(token);

        log.debug("name = {}" , getName);

        int count  = 0;

        while (true){

            try{
                boolean result = JwtUtil.verify(token,user,password);

                log.debug("verify result = {} ,time = {}s",result,count++);

                Thread.sleep(1000);

            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }
}


