package com.ruoyi.study.util;

/**
 * 金虎加密工具类
 *
 * @author YJH
 */
public class TigerEncryptUtils {
    /**
     * 加密
     *
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String encrypt(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 0x5a);
        }
        return new String(bytes);
    }
    
    /**
     * 解密
     *
     * @param str 需要解密的字符串
     * @return 解密后的字符串
     */
    public static String decrypt(String str) {
        byte[] bytes = str.getBytes();
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (bytes[i] ^ 0x5a);
        }
        return new String(bytes);
    }
}
