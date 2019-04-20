package com.example.demo.util;

/*
auth0的java-jwt是一个JSON WEB TOKEN（JWT）的一个实现。
*/
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtils {

    /*
    * 公用秘钥 - 保存在服务端 客户端是不会知道秘钥，以防止被攻击
    * */
    public static String SECRET = "Dontlietome";

    private String secret;
    private long expire;
    private String header;

    /*
    * 生成token
    * */

    public static String createToken() throws Exception{
        //签发时间
        Date iatDate = new Date();

        //过期时间 -1分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,1);
        Date expiresDate = nowTime.getTime();

        Map<String,Object> map = new HashMap<String, Object>();

        map.put("alg","HS256");//加密算法
        map.put("typ","JWT");//加密类型

        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("name","Free码农")//设置payload
                .withClaim("age","25")//
                .withClaim("org","今日头条")//
                .withIssuedAt(iatDate)//设置签发时间
                .withExpiresAt(expiresDate)//设置过期时间 且 iat<exp
                .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
    }

    /*
    * 解密token
    * */

    public static Map<String,Claim> verifyToken(String token)throws Exception{
        JWTVerifier verifier =  JWT.require(Algorithm.HMAC256(SECRET))
                .build();

        System.out.println(verifier);

        DecodedJWT jwt = null;

        try{
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录凭证已过期，请重新登录！");
        }

      return jwt.getClaims();
    }

   /* public static void main(String[] args)throws Exception{
        String token = JWTUtils.createToken();

        System.out.println("Token: " + token);

        Map<String,Claim> claims = JWTUtils.verifyToken(token);

        System.out.println(claims.get("name").asString());
        System.out.println(claims.get("age").asString());
        System.out.println(claims.get("org")==null?null:claims.get("org").asString());

        //使用过期后的token进行校验
        String tokenExpire = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9."+
                "eyJvcmciOiLku4rml6XlpLTmnaEiLCJuYW1lIjoiRnJlZeeggeWGnCIsImV4c"+
                "CI6MTUxNDM1NjEwMywiaWF0IjoxNTE0MzU2MDQzLCJhZ2UiOiIyOCJ9."+
                "49UF72vSkj-sA4aHHiYN5eoZ9Nb4w5Vb45PsLF7x_NY";

        Map<String,Claim> claimExpire = JWTUtils.verifyToken(tokenExpire);


    }*/

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public long getExpire() {
        return expire;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}