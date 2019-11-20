package com.niit.web.blog.util;

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
