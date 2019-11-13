package com.niit.web.blog.dao.impl;

import com.niit.web.blog.dao.AddressDao;
import com.niit.web.blog.entity.Address;
import com.niit.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @ClassName AddressDaoImpl
 * @Description TODO
 * @Date 2019/11/13
 * @Version 1.0
 **/
public class AddressDaoImpl implements AddressDao {
    @Override
    public int[] batchInsert(List<Address> addressesList) throws SQLException {
        Connection connection = DbUtil.getConnection();
        connection.setAutoCommit(false);
        String sql = "INSERT INTO t_address (address) VALUES (?) ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        addressesList.forEach(address -> {
            try {
                pstmt.setString(1, address.getAddress());
                pstmt.addBatch();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        int[] result = pstmt.executeBatch();
        //别忘记提交
        connection.commit();
        pstmt.close();
        connection.close();
        return result;
    }
}
