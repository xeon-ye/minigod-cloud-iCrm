package com.minigod.common.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.KeySpec;
import java.security.spec.RSAPrivateKeySpec;

/**
 * RSA性能是非常低的，原因在于寻找大素数、大数计算、数据分割需要耗费很多的CPU周期，所以一般的HTTPS连接只在第一次握手时使用非对称加密，通过握手交换对称加密密钥，在之后的通信走对称加密
 */
public class RSAUtil {
    private static final Logger logger = LoggerFactory.getLogger(RSAUtil.class);

    public static String decrypt(String data, String key) {
        try {
            if ((SecurityUtil.isBlank(data)) || (SecurityUtil.isBlank(key))) {
                throw new MiniGodSecurityException("RSA decrypt parameter error.");
            }
            byte[] outKey = decrypt(key, SecurityKey.RSA_N, SecurityKey.RSA_E, SecurityKey.RSA_D);
            byte[] aesKey = new byte[16];
            byte[] aesIV = new byte[16];
            System.arraycopy(outKey, 0, aesKey, 0, 16);
            System.arraycopy(outKey, 16, aesIV, 0, 16);
            return AESUtil.decrypt(data.getBytes("UTF-8"), aesKey, aesIV);
        } catch (Exception e) {
            logger.error("RSA decrypt error,", e);
            throw new MiniGodSecurityException("RSA decrypt.", e);
        }
    }

    private static byte[] decrypt(String rsaKey, String N, String E, String D) {
        try {
            byte[] baseKey = Base64.decode(rsaKey.getBytes("UTF-8"));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            KeySpec keySpec = new RSAPrivateKeySpec(new BigInteger(N), new BigInteger(D));
            Key key = keyFactory.generatePrivate(keySpec);
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(2, key);
            return cipher.doFinal(baseKey);
        } catch (Exception e) {
            logger.error("RSA decrypt error,", e);
            throw new MiniGodSecurityException("RSA decrypt.", e);
        }
    }

    public static void main(String[] args) {
        String a = decrypt("33pt+nwp7kSS6+t1HnmhtpBYYD8Iuga7iPaHKlGHvgc=", "e44I+63w4ldMJY56IeO67hiJW35DkNp/xyrJ+HIwlbMAEZucbGS0Q+dtSRzK5Qr5KeGJPoWzdlZDuuLWaSZL56QVUCPosXXrF3NVqKhMn9d5cjaDQx/yu/dsYHHm/HDzAYfjJh+rkuedWEDsOsn4WKiRF/MQVcj5hzV/ClUeBfM=");
        System.err.println("dddddddddddddd:" + a);
    }
}