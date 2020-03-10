package com.minigod.account.helper;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.minigod.common.odps.service.RedisMapService;
import com.minigod.common.utils.DateUtils;
import com.minigod.protocol.account.model.CustomDevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class JwtHelper {
    @Autowired
    public RedisMapService redisMapService;

    @Value("${minigod.config.authCode.expireSecond}")
    private int expireSecond;

    // 秘钥
    static final String SECRET = "X-Access-Auth-Code";
    // 签名是有谁生成
    static final String ISSUSER = "MINIGOD";
    // 签名的主题
    static final String SUBJECT = "this is out sys auth code";
    // 签名的观众
    static final String AUDIENCE = "OUT_SYSTEM";


    public String createAuthCode(Integer deviceId) {
        try {
            Date expireDate = DateUtils.addSecond(new Date(), expireSecond);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            String authCode = JWT.create()
                    // 设置头部信息 Header
                    .withHeader(map)
                    // 设置 载荷 Payload
                    .withClaim("deviceId", deviceId)
//                    .withClaim("deviceCode", customDevice.getDeviceCode())
//                    .withClaim("deviceType", Integer.valueOf(customDevice.getDeviceType()))
//                    .withClaim("osType", Integer.valueOf(customDevice.getOsType()))
//                    .withClaim("osVersion", customDevice.getOsVersion())
//                    .withClaim("appId", customDevice.getAppId())
//                    .withClaim("appVersion", customDevice.getAppVersion())
                    .withIssuer(ISSUSER)
                    .withSubject(SUBJECT)
                    .withAudience(AUDIENCE)
                    // 生成签名的时间
                    .withIssuedAt(new Date())
                    // 签名过期的时间
                    .withExpiresAt(expireDate)
                    // 签名 Signature
                    .sign(algorithm);
            return authCode;
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public Integer verifyAuthCodeAndGetDeviceId(String authCode) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUSER)
                    .build();
            DecodedJWT jwt = verifier.verify(authCode);
            Map<String, Claim> claims = jwt.getClaims();
            Claim deviceId = claims.get("deviceId");
//            Claim deviceCode = claims.get("deviceCode");
//            Claim deviceType = claims.get("deviceType");
//            Claim osType = claims.get("osType");
//            Claim osVersion = claims.get("osVersion");
//            Claim appId = claims.get("appId");
//            Claim appVersion = claims.get("appVersion");
//
//            CustomDevice customDevice = new CustomDevice();
//
//            customDevice.setId(deviceId.asInt());
//            customDevice.setDeviceCode(deviceCode.asString());
//            customDevice.setDeviceType(deviceType.asInt().byteValue());
//            customDevice.setOsType(osType.asInt().byteValue());
//            customDevice.setOsVersion(osVersion.asString());
//            customDevice.setAppId(appId.asInt());
//            customDevice.setAppVersion(appVersion.asString());

            return deviceId.asInt();
        } catch (JWTVerificationException exception) {
            exception.printStackTrace();
        }

        return null;
    }


}
