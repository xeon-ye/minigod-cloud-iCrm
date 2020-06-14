package com.minigod.common.security;

import java.net.URLEncoder;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUtil {
    private static String CHARACTER = "UTF-8";

    public SignUtil() {
    }
    public static boolean validateSign(String param, String key, String sign) {
        try {
            if (!SecurityUtil.isBlank(param) && !SecurityUtil.isBlank(sign)) {
                String data = key + param + key;
                byte[] decodeKey = Base64.decode(sign.getBytes(CHARACTER));
                byte[] indata = data.getBytes(CHARACTER);
                byte[] outdata = SHA1.digest(indata, 0, indata.length);
                return (new String(decodeKey)).equals(new String(outdata));
            } else {
                return false;
            }
        } catch (Exception var7) {
            throw new MiniGodSecurityException("validateSign error.", var7);
        }
    }

    public static String sign(String data, String key) {
        try {
            if (!SecurityUtil.isBlank(data) && !SecurityUtil.isBlank(key)) {
                data = key + data + key;
                byte[] indata = data.getBytes(CHARACTER);
                byte[] outdata = SHA1.digest(indata, 0, indata.length);
                outdata = Base64.encode(outdata);
                return new String(outdata);
            } else {
                return null;
            }
        } catch (Exception var4) {
            throw new MiniGodSecurityException("sign error.", var4);
        }
    }

    public static String convertUnicode(String params) {
        int len = params.length();
        StringBuffer outBuffer = new StringBuffer(len);
        int x = 0;

        while(true) {
            while(true) {
                while(x < len) {
                    char paramChar = params.charAt(x++);
                    if (paramChar == '\\') {
                        paramChar = params.charAt(x++);
                        if (paramChar == 'u') {
                            int value = 0;

                            for(int i = 0; i < 4; ++i) {
                                paramChar = params.charAt(x++);
                                switch(paramChar) {
                                    case '0':
                                    case '1':
                                    case '2':
                                    case '3':
                                    case '4':
                                    case '5':
                                    case '6':
                                    case '7':
                                    case '8':
                                    case '9':
                                        value = (value << 4) + paramChar - 48;
                                        break;
                                    case ':':
                                    case ';':
                                    case '<':
                                    case '=':
                                    case '>':
                                    case '?':
                                    case '@':
                                    case 'G':
                                    case 'H':
                                    case 'I':
                                    case 'J':
                                    case 'K':
                                    case 'L':
                                    case 'M':
                                    case 'N':
                                    case 'O':
                                    case 'P':
                                    case 'Q':
                                    case 'R':
                                    case 'S':
                                    case 'T':
                                    case 'U':
                                    case 'V':
                                    case 'W':
                                    case 'X':
                                    case 'Y':
                                    case 'Z':
                                    case '[':
                                    case '\\':
                                    case ']':
                                    case '^':
                                    case '_':
                                    case '`':
                                    default:
                                        throw new IllegalArgumentException("Malformed \\uxxxx  encoding.");
                                    case 'A':
                                    case 'B':
                                    case 'C':
                                    case 'D':
                                    case 'E':
                                    case 'F':
                                        value = (value << 4) + 10 + paramChar - 65;
                                        break;
                                    case 'a':
                                    case 'b':
                                    case 'c':
                                    case 'd':
                                    case 'e':
                                    case 'f':
                                        value = (value << 4) + 10 + paramChar - 97;
                                }
                            }

                            outBuffer.append((char)value);
                        } else {
                            outBuffer.append(paramChar);
                        }
                    } else {
                        outBuffer.append(paramChar);
                    }
                }

                return outBuffer.toString();
            }
        }
    }

    public static String getParams(String params) {
        try {
            params = convertUnicode(params);
//            System.err.println("格式化:" + params);
            Pattern p = Pattern.compile("[^0-9a-zA-Z一-龥]+");
            Matcher m = p.matcher(params);
            params = m.replaceAll("");
//            System.err.println("过滤:" + params);
            params = URLEncoder.encode(params, "UTF8");
//            System.err.println("编码:" + params);
            char[] ar = params.toCharArray();
            Arrays.sort(ar);
            return String.valueOf(ar);
        } catch (Exception var4) {
            throw new MiniGodSecurityException("sign error.", var4);
        }
    }

    public static void main(String[] args) {
        String pa2 = "{\n" +
                "\t\t\"certType\": 0,\n" +
                "\t\t\"certCode\": 18938070402,\n" +
                "\t\t\"loginWay\": 1,\n" +
                "\t\t\"password\": 184038,\n" +
                "\t\t\"captchaId\": 14\n" +
                "\t}";
        String key = "18938070402";
        System.out.println("pa2:" + pa2);
        String b2 = getParams(pa2);
        System.err.println("排序:" + b2);
        System.err.println("签名:" + sign(b2, key));
    }
}
