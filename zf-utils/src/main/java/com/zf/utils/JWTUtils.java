package com.zf.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: 段誉
 * Date: 2019/8/28
 * Time: 15:18
 * Description: No Description
 */
@Component
public class JWTUtils {

    @Value("${authorization.app_id}")
    private String APP_ID;

    @Value("${authorization.app_secret}")
    private String APP_SECRET;

    /**
     * 用户登录成功后生成Jwt
     * 使用Hs256算法  私匙使用用户密码
     *
     * @param ttMillis jwt过期时间
     * @param subject
     * @return
     */
    public String createJWT(long ttMillis, String subject){

        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        //Map<String, Object> claims = new HashMap<String, Object>();
        //claims.put("id","");
        //claims.put("username","");
        //claims.put("password","");

        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，
        // 在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
        byte[] apiKeySecreBytes = DatatypeConverter.parseBase64Binary(APP_ID + APP_SECRET);
        Key signingKey = new SecretKeySpec(apiKeySecreBytes, signatureAlgorithm.getJcaName());

        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                //.setClaims(claims)
                //设置jti(JWT ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志
                .setSubject(subject)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm,signingKey);
        //如果过期时间大于0
        if(ttMillis>0){
            //当前时间戳+过期时间戳
            long expMillis = nowMillis + ttMillis;
            Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * Token的解密
     * @param jwt 加密后的token
     * @return
     */
    public Claims parseJWT(String jwt){

        //获取秘钥
        byte[] bytes = DatatypeConverter.parseBase64Binary(APP_ID + APP_SECRET);
        //得到DefaultJwtParser
        Claims claims = Jwts.parser()
                        //设置秘钥
                        .setSigningKey(bytes)
                        //设置需要解析的jwt
                        .parseClaimsJws(jwt).getBody();
        return  claims;
    }

    /**
     * 校验token
     *  在这里可以使用官方的校验，我这里校验的是token中携带的手机号于数据库一致的话就校验通过
     * @param jwt
     * @param subject
     * @return
     */
    public Boolean isVerify(String jwt, String subject){
        try {
            //获取加密后的米亚
            byte[] bytes = DatatypeConverter.parseBase64Binary(APP_ID + APP_SECRET);
            //得到DefaultJwtParser
            Claims claims = Jwts.parser()
                    //设置的秘钥
                    .setSigningKey(bytes)
                    //设置需要解析的jwt
                    .parseClaimsJws(jwt).getBody();
            //如果token中subject如传入的值相同直接返回ture
            if(claims.getSubject().equals(subject)){return true;}
            return false;
        }catch (Exception e){
            throw  new RuntimeException("token过期,请重新登录");
        }

    }
}
