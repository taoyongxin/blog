package com.niit.web.blog.entity;

import lombok.Data;

/**
 * @author Tao
 * @ClassName Region
 * @Description 全国省市区地址Region实体类
 * @Date 2019/11/30
 * @Version 1.0
 **/
@Data
public class Region {
    private  Integer id;
    private String name;
    private Integer parentId;
    private Integer level;
    private String cityCode;
    private String postCode;
    private String mergeName;
}
