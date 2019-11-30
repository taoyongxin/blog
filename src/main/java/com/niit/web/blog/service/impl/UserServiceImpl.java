package com.niit.web.blog.service.impl;

import com.niit.web.blog.dao.ArticleDao;
import com.niit.web.blog.dao.UserDao;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.domain.vo.ArticleVo;
import com.niit.web.blog.domain.vo.UserVo;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.util.Message;
import com.niit.web.blog.util.Result;
import com.niit.web.blog.util.ResultCode;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Date 2019/11/9
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Result signIn(UserDto userDto) {
        User user = null;
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if(user != null){
            //数据库查到的用户密码和前端传递的用户密码（经过加密）相等
            if(user.getPassword().equals(DigestUtils.md5Hex(userDto.getPassword()))){
                //登录成功
                return Result.success(user);
            } else {
                //密码错误
                return Result.failure(ResultCode.USER_PASSWORD_ERROR);
            }
        } else {
            //帐号错误
            return Result.failure(ResultCode.USER_ACCOUNT_ERROR);
        }

        /*User user = null;
        Map<String,Object> map = new HashMap<>();
        try {
            user = userDao.findUserByMobile(userDto.getMobile());
        } catch (SQLException e) {
            logger.error("根据手机号查询用户出现异常");
        }
        if(user != null){
            if (user.getPassword().equals(userDto.getPassword())){
                map.put("msg","登陆成功");
                map.put("data",user);
            }else {
                map.put("msg","密码错误");
            }
        }else{
            map.put("msg","手机号不存在");
        }
        return map;*/
    }

    @Override
    public Map<String, Object> signUp(UserDto userDto) {
        Map<String,Object> map = new HashMap<>();
        int i = 0;
        try {
            i = userDao.insert(userDto);
        } catch (SQLException e) {
            logger.error("注册失败");
        }
        if(i == 1){
            map.put("msg", Message.REGISTER_SUCCESS);
            map.put("data",userDto);
            logger.info("注册"+userDto.getMobile()+"注册成功");
        }else {
            map.put("msg",Message.REGISTER_DEFEATED);
        }
        return map;
    }

    @Override
    public Result getAllUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectAll();
        } catch (SQLException e) {
            logger.error("获取热门用户");
        }
        if (userList != null){
            return Result.success(userList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getHotUsers() {
        List<User> userList = null;
        try {
            userList = userDao.selectHotUsers();
        } catch (SQLException e) {
            logger.error("获取所有用户");
        }
        if (userList != null){
            return Result.success(userList);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByPage(int currentPage, int count) {
        List<User> userList = null;
        try {
            userList = userDao.selectByPage(currentPage, count);
        } catch (
                SQLException e) {
            logger.error("分页查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByKeywords(String keywords) {
        List<User> userList = null;
        try {
            userList = userDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            logger.error("根据关键字查询用户出现异常");
        }
        if (userList != null) {
            return Result.success(userList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }



   /* @Override
    public List<User> listUser() {
        List<User> users = null;
        try {
            users = userDao.selectAll();
        } catch (SQLException e) {
            System.err.println("查询用户操作失败");
        }
        return users;
    }*/

   /* @Override
    public List<User> listHotUsers() {
        List<User> users = null;
        try {
            users = userDao.selectHotUsers();
        } catch (SQLException e) {
            System.err.println("查询热门用户操作失败");
        }
        return users;
    }*/

    @Override
    public Result getUser(long id) {
        UserVo userVo = null;
        try {
            userVo = userDao.getUser(id);
        } catch (SQLException e) {
            logger.error("根据id获取用户详情出现异常");
        }
        if (userVo != null) {
            try {
                List<ArticleVo> articleVoList = articleDao.selectByUserId(id);
                userVo.setArticleList(articleVoList);
                return Result.success(userVo);
            } catch (SQLException e) {
                logger.error("根据用户id获取文章列表数据出现异常");
            }
        }
        return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
    }


}
