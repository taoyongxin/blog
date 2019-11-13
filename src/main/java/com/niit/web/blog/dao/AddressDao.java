package com.niit.web.blog.dao;

import com.niit.web.blog.entity.Address;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName AddressDao
 * @Description TODO
 * @Date 2019/11/13
 * @Version 1.0
 **/
public interface AddressDao {
    /**
     * 批量插入全国省市区地址
     * @param addressesList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<Address> addressesList) throws SQLException;
}
