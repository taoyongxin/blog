package com.niit.web.blog.domain.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Tao
 * @ClassName UserVo
 * @Description TODO
 * @Date 2019/11/25
 * @Version 1.0
 **/
public class UserVo {
    private Long id;
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
    private LocalDateTime create_time;
}
