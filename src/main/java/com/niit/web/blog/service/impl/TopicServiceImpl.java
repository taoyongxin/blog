package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.TopicDao;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.TopicService;
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

    @Override
    public List<Topic> listtopic() {
        List<Topic> topics = null;
        try {
            topics = topicDao.selectHotTopics();
        } catch (SQLException e) {
            logger.error("查询所有专题用户失败");
        }
        return topics;
    }
}
