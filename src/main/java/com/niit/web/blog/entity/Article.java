package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @ClassName Article
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
public class Article {
    private long id;
    private String title;//文章标题
    private String articlemain;//文章主体内容
    private String articlepic;//文章附带图片
    private long comment;//评论数
    private long praise;//转发数
    private long userid;//作者用户id
    private LocalDateTime publishtime;//发布时间
}
