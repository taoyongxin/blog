package com.niit.web.blog.domain.vo;

import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author Tao
 * @ClassName UserVo
 * @Description TODO
 * @Date 2019/11/25
 * @Version 1.0
 **/
@Data
public class UserVo {
    /*private Long id;
    private String mobile;
    private String nickname;
    private String avatar;
    private String gender;
    private LocalDate birthday;
    private String address;
    private String introduction;
    private int follows;
    private int fans;
    private int articles;
    private LocalDateTime create_time;*/

    private User user;
    private List<ArticleVo> articleList;
    private List<Topic> topicList;
    private List<User> fansList;
}
