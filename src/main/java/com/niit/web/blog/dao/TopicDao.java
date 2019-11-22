package com.niit.web.blog.dao;

import com.niit.web.blog.domain.vo.TopicVo;
import com.niit.web.blog.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName TopicDao
 * @Description TODO
 * @Date 2019/11/17
 * @Version 1.0
 **/
public interface TopicDao {
    /**
     * 爬取简书网专题
     * @param topicList
     * @return
     * @throws SQLException
     */
    int[] bathInsert(List<Topic> topicList) throws SQLException;

    /**
     * 查询热门专题
     * @return
            * @throws SQLException
     */
    List<Topic> selectHotTopics() throws SQLException;

    /**
     * 根据专题表的管理员的id匹配用户表的用户id进行双表联查，通过id查询指定专题
     * @param id
     * @return
     * @throws SQLException
     */
    TopicVo getTopic(long id) throws SQLException;


}
