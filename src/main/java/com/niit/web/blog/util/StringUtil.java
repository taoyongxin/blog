package com.niit.web.blog.util;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Tao
 * @ClassName StringUtil
 * @Description 字符串工具类
 * @Date 2019/11/18
 * @Version 1.0
 **/
public class StringUtil {
    /**
     * 提取字符串中的数字字符为一个字符串的数组
     * @param sourceStr
     * @return
     */
    public static String[] getDigital(String sourceStr){
        String[] result = new String[sourceStr.length()];
        Pattern p = Pattern.compile("\\d{2,}");
        //2指连续数字最少个数
        Matcher m =p.matcher(sourceStr);
        int i= 0;
        while(m.find()){
            result[i] = m.group();
            i++;
        }
        return result;
    }
    final static int MAX = 4;
    static char c;

    public static String getRandomString() {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        int index;
        char c;
        String[] choice = {"数字", "大写字母", "小写字母"};
        for (int i = 0; i < MAX; i++) {
            index = random.nextInt(3);
            switch (index) {
                case 0:
                case 1:
                case 2:
                    char result = getChar(index);
                    stringBuilder.append(result);
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static char getChar(int item) {

        int digitalBound = 10;
        int charBound = 26;
        Random random = new Random();
        int index;
        if (item == 0) {
            index = random.nextInt(digitalBound);
            c = (char) ('0' + index);
        } else if (item == 1) {
            index = random.nextInt(charBound);
            c = (char) ('A' + index);
        } else {
            index = random.nextInt(charBound);
            c = (char) ('a' + index);
        }
        return c;
    }


    public  static void main(String[] args){
        Pattern p =Pattern.compile("\\d{2,}");
        String u = "收录21555篇文章，324235人关注";
        Matcher m = p.matcher(u);
        int i = 0;
        while(m.find()){
            System.out.println(m.group());
            i++;
        }
    }

}
