package com.niit.web.blog.util;

import com.aliyun.oss.OSSClient;

import java.io.File;

/**
 * @author Tao
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Date 2019/11/6
 * @Version 1.0
 **/
public class AliOSSUtil {
    public static String ossUpload(File file) {
        String bucketDomain = "https://niit-student.oss-cn-beijing.aliyuncs.com/";
        String endpoint = "oss-cn-beijing.aliyuncs.com";
        String accessKeyId ="LTAI4FvqK568YDj7HtsPEZ5d";
        String accessKeySecret = "VMfoqfNr2TpdzQVc9sLIOmSt5f5rhN";
        String bucketName = "niit-student";
        String filedir = "avatar/";
        String fileName = file.getName();
        System.out.println(fileName);
        String fileKey = "taoyongxin"+fileName.substring(fileName.indexOf("."));
        OSSClient ossClient = new OSSClient(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,filedir + fileKey,file);
        StringBuffer url = new StringBuffer();
        url.append(bucketDomain).append(filedir).append(filedir).append(fileKey);
        ossClient.shutdown();
        return url.toString();
    }
    public static void main(String[] args){
        File file = new File("E:/1.jpg");
        String url = ossUpload(file);
        System.out.println(url);
    }
}
