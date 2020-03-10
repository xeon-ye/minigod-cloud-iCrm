package com.minigod.common.security;

import java.security.MessageDigest;

public class SHA1 {
    public SHA1() {
    }

    private static MessageDigest sha1() {
        try {
            return MessageDigest.getInstance("SHA-1");
        } catch (Exception var1) {
            throw new MiniGodSecurityException(var1);
        }
    }

    public static void reset() {
        MessageDigest sha1 = sha1();
        sha1.reset();
    }

    public static void update(byte[] indata) {
        MessageDigest sha1 = sha1();
        sha1.update(indata);
    }

    public static void update(byte[] indata, int inoff, int inlen) {
        MessageDigest sha1 = sha1();
        sha1.update(indata, inoff, inlen);
    }

    public static int Final(byte[] outdata, int outoff) {
        MessageDigest sha1 = sha1();

        try {
            return sha1.digest(outdata, outoff, 20);
        } catch (Exception var4) {
            throw new MiniGodSecurityException(var4);
        }
    }

    public static byte[] Final() {
        MessageDigest sha1 = sha1();
        return sha1.digest();
    }

    public static byte[] digest(byte[] indata, int inoff, int inlen) {
        MessageDigest sha1 = sha1();
        sha1.reset();
        sha1.update(indata, inoff, inlen);
        return sha1.digest();
    }

    public static void digest(byte[] indata, int inoff, int inlen, byte[] outdata, int outoff) {
        MessageDigest sha1 = sha1();

        try {
            sha1.reset();
            sha1.update(indata, inoff, inlen);
            sha1.digest(outdata, outoff, 20);
        } catch (Exception var7) {
            throw new MiniGodSecurityException(var7);
        }
    }

    public static byte[] digest(byte[] indata) {
        MessageDigest sha1 = sha1();
        sha1.reset();
        sha1.update(indata);
        return sha1.digest();
    }
}
