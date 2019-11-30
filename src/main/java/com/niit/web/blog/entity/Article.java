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
    private Long id;
    private Long userId;
    private Long topicId;
    private String title;
    private String summary;
    private String thumbnail;
    private String content;
    private Integer likes;
    private Integer comments;
    private LocalDateTime createTime;
}
