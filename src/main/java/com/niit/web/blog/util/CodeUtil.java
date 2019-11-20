package com.niit.web.blog.util;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Tao
 * @ClassName CodeUtil
 * @Description TODO
 * @Date 2019/11/19
 * @Version 1.0
 **/
public class CodeUtil {
    public static String getRandomCode(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<4;i++){
            int temp = random.nextInt(26) + 97;
            String s = String.valueOf((char) temp);
            sb.append(s);
        }
        return String.valueOf(sb);
    }



    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time1 =df.format(new Date());
        System.out.println(time1);
        File dir = new File("E:/JavaWeb/web/"+time1);
        dir.mkdirs();

        File file1 = new File("E:/JavaWeb/123.txt");
        File file2 = new File("E:/JavaWeb/web/"+time1+"/UUID.txt");

        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] bytes = new byte[10];
        int len = 0;
        try {
            fis = new FileInputStream(file1);
            fos = new FileOutputStream(file2);

            try {
                while ((len = fis.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
