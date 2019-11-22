package com.niit.web.blog.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author Tao
 * @ClassName DataUtil
 * @Description 数据生成工具，用来生成用户的一些数据
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class DataUtil {
    /**
     * 获得电话号码
     * @return
     */
    public static String getMobile(){
        StringBuilder stringBuilder = new StringBuilder("139");
        Random random = new Random();
        for (int i = 0; i < 8; i++){
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    public static String getCode(){
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<4;i++){
            int num = random.nextInt(10);
            stringBuilder.append(num);
        }
        return stringBuilder.toString();
    }

    /**
     * 随机生成发布作者用户id
     * @return
     */
    public static int getUser_id(){
        Random random = new Random();
        int sum = random.nextInt(72)+1;
        return sum;
    }
    public static int getComment(){
        Random random = new Random();
        int sum = random.nextInt(9999);
        return sum;
    }
    public static int getPraise(){
        Random random = new Random();
        int sum = random.nextInt(9999);
        return sum;
    }
    /**
     * 生成密码
     * @return
     */
    public static String getPassword(){
        StringBuilder password = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<6;i++){
            int num = random.nextInt(6);
            password.append(num);
        }
        //调用common-codec的Md5加密功能
        return DigestUtils.md5Hex(password.toString());
    }

    /**
     * 随机生成生日
     * @return
     */
    public static LocalDate getBirthday(){
        LocalDate now = LocalDate.now();
        Random random = new Random();
        int bound = random.nextInt(8888);
        return now.minusDays(bound);
    }

    /**
     * 随机生成文章发布时间
     * @return
     */
    public static LocalDateTime getPublishtime(){
        LocalDateTime now = LocalDateTime.now();
        Random random = new Random();
        int bound = random.nextInt(8888);
        return now.minusMinutes(bound);
    }



    /**
     * 随机生成性别
     * @return
     */
    public static String getGender(){
        String[] genders = new String[]{"男","女"};
        Random random = new Random();
        int index = random.nextInt(2);
        return genders[index];
    }

    public static Long getUserId(){
        Random random = new Random();
        long bound = random.nextInt(61);
        return bound;
    }

    public static Long getTopicId(){
        Random random = new Random();
        long bound = random.nextInt(72)+1;
        return bound;
    }











}
