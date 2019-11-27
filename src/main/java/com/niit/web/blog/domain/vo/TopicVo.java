package com.niit.web.blog.domain.vo;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author Tao
 * @ClassName TopicVo
 * @Description 专题视图类，包含专题本身信息，专题下所有文章、创建者信息(简略)、关注者信息(简略)
 * @Date 2019/11/22
 * @Version 1.0
 **/
@Data
public class TopicVo {
   /* private Long id;
    private Long admin_id;
    private String topic_name;
    private String logo;
    private String description;
    private Integer articles;
    private Integer follows;
    private LocalDateTime create_time;
    private List<ArticleVo> articleList;
    private SimpleUser simpleUser;
    private List<SimpleUser> simpleUsers;*/
    private Topic topic;
    private User admin;
    private List<ArticleVo> articleList;
    private List<User> followList;
}
