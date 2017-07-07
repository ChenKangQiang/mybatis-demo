package edu.tongji.comm.typical.demo.utils;

import java.util.Random;

/**
 * Created by chen on 2017/7/7.
 */
public class RandomUtil {

    /**
     * 生成一个随机字符串
     * @param length 字符串长度
     * @return
     */
    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int num = random.nextInt(62);
            builder.append(str.charAt(num));
        }
        return builder.toString();
    }

}
