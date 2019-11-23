package com.niit.web.blog.domain.vo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @ClassName ArticleVo
 * @Description 文章视图类,文章表和用户表的双表联查出前端所需表的数据信息
 * @Date 2019/11/17
 * @Version 1.0
 **/
@Data
public class ArticleVo {
    private Long id;
    private Long user_id;
    private Long topic_id;
    private String nickname;
    private String avatar;
    private String title;
    private String summary;
    private String article_pic;
    private String content;
    private Integer comment;
    private Integer praise;
    private String topic_name;
    private String logo;
    private LocalDateTime create_time;
}
