package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.TopicDao;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.TopicService;
import com.niit.web.blog.util.Result;
import com.niit.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @Date 2019/11/20
 * @Version 1.0
 **/
public class TopicServiceImpl implements TopicService {
    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);

    /**
     * 未封装的获取所有文章
     * @return
     */
    @Override
    public List<Topic> listtopic() {
        List<Topic> topics = null;
        try {
            topics = topicDao.selectHotTopics();
        } catch (SQLException e) {
            logger.error("查询所有热门前十专题失败");
        }
        return topics;
    }

    /**
     * 封装后的获取所有文章
     * @return
     */
    @Override
    public Result getHotTopics() {
         List<Topic> topicList = null;
        try {
            topicList = topicDao.selectHotTopics();
        } catch (SQLException e) {
            logger.error("获取热门专题出现异常");
        }
        if(topicList != null){
            return Result.success(topicList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

   /* @Override
    public List<Topic> ListAllTopic() {
        List<Topic> topics = null;
        try {
            topics = topicDao.selectAllTopic();
        } catch (SQLException e) {
            logger.error("查询所有专题失败");
        }
        return topics;
    }*/

    @Override
    public Result getAllTopic() {
        List<Topic> topicList = null;
        try {
            topicList = topicDao.selectAllTopic();
        } catch (SQLException e) {
            logger.error("获取所有专题出现异常");
        }
        if(topicList != null){
            return  Result.success(topicList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
