package com.ivanz.shortlink.admin.utils;

import java.security.SecureRandom;

/**
 * 分组ID随机生成器
 */
public final class RandomGenerator {

    private static final String CHARACTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom RANDOM = new SecureRandom();

    /**
     * 生成随机分组ID
     *
     * @return 分组ID
     */
    public static String generateRandom() {
        return generateRandom(6);
    }


    /**
     * 生成随机分组ID
     *
     * @param length 生成ID长度
     * @return 分组ID
     */
    public static String generateRandom(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
