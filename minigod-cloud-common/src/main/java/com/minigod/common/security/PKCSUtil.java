package com.minigod.common.security;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.util.Base64Utils;

import java.security.*;

@Slf4j
public class PKCSUtil {
    public static KeyPair generageKeyPair() {
        KeyPair kp = null;
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
            keyGen.initialize(2048);
            kp = keyGen.generateKeyPair();
        } catch (Exception e) {
            log.error("生成KeyPair失败");
        }
        return kp;
    }

    public static String genereatePkcs10(KeyPair keyPair, String dn) {
        String p10Code = "";
        try {
            // 获取RSA P10数据
            X500Name subject = new X500Name(dn);
            PKCS10CertificationRequestBuilder builder = new PKCS10CertificationRequestBuilder(subject, SubjectPublicKeyInfo.getInstance(keyPair.getPublic().getEncoded()));
            JcaContentSignerBuilder jcaContentSignerBuilder = new JcaContentSignerBuilder("SHA256WithRSA");
            ContentSigner contentSigner = jcaContentSignerBuilder.build(keyPair.getPrivate());
            PKCS10CertificationRequest p10 = builder.build(contentSigner);

            byte[] der = p10.getEncoded();
            p10Code = new String(Base64.encode(der));
        } catch (Exception e) {
            log.error("P10签名失败");
        }

        return p10Code;

    }

    public static String genereatePkcs1(KeyPair keyPair, String hash) {
        String p1Code = "";
        try {
            // 获取
            byte[] h = Base64Utils.decodeFromString(hash);
            PrivateKey privateKey = keyPair.getPrivate();
            java.security.Signature signet = java.security.Signature.getInstance("SHA256WithRSA");
            signet.initSign(privateKey);
            signet.update(h);
            byte[] signed = signet.sign();
            p1Code = Base64Utils.encodeToString(signed);
        } catch (Exception e) {
            log.error("P1签名失败");
        }

        return p1Code;

    }

    public static void main(String[] args) {
        KeyPair kp = PKCSUtil.generageKeyPair();
        PKCSUtil.genereatePkcs1(kp, "BUTwybPlJ2ShvgWblJzrxOfYKg8=");
    }
}