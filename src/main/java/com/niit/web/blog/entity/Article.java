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
    private String article_pic;//文章附带图片
    private int comment;//评论数
    private int praise;//转发数
    private long user_id;//作者用户id
    private LocalDateTime creat_time;//发布时间
    private String summary;//文章主体内容
    private String content;
}
