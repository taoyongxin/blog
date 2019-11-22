package com.niit.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @ClassName Article
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
@Data
/*为该类产生无参的构造方法和包含所有参数的构造方法*/
@AllArgsConstructor
@NoArgsConstructor
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
    private Long topic_id;//文章所属专题id
}
