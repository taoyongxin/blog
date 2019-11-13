package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Address;
import com.niit.web.blog.factory.DaoFactory;
import com.niit.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class AddressDaoTest {
    private static Logger logger = LoggerFactory.getLogger(AddressDao.class);
    private AddressDao addressDao = DaoFactory.getAddressDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result = addressDao.batchInsert(JSoupSpider.getAddress());
            if (result.length != 0){
                logger.info("批量新增用户成功");
            }else{
                logger.error("错误");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户失败");

        }
    }
}