package com.dang.java.utils;

import java.security.MessageDigest;

public class MD5Util {

    public static String string2MD5(String inStr) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = inStr.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++) {
            byteArray[i] = (byte) charArray[i];
        }
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

    public static String string2MD5_16(String s) {
        return string2MD5(s).substring(8, 24);
    }

    /**
     * 加密解密算法 执行一次加密，两次解密
     */
    public static String convertMD5(String inStr) {

        char[] a = inStr.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;

    }

    // 测试主函数
    public static void main(String args[]) {
        String s = new String("dang");
        System.out.println("原始：" + s);
        System.out.println("16位Md5：" + string2MD5(s).substring(8, 24));
        String md5 = string2MD5(s);
        System.out.println("MD5后：" + md5);
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5("\u0010\u0015\u001A\u0013"));

    }
}
