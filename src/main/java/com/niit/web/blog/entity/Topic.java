package com.niit.web.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @ClassName Topic
 * @Description TODO
 * @Date 2019/11/17
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    private Long id;
    private Long admin_id;
    private String topic_name;
    private String logo;
    private String description;
    private Integer articles;
    private Integer follows;
    private LocalDateTime create_time;
}
