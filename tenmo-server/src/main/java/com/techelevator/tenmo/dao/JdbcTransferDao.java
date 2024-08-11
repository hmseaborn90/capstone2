package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//@Component
//public class JdbcTransferDao implements TransferDao{
////    @Override
////    public List<Transfer> getTransfers() {
////        List<User> users = new ArrayList<>();
////        String sql = "SELECT user_id, username, password_hash FROM tenmo_user";
////        try {
////            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
////            while (results.next()) {
////                User user = mapRowToUser(results);
////                users.add(user);
////            }
////        } catch (CannotGetJdbcConnectionException e) {
////            throw new DaoException("Unable to connect to server or database", e);
////        }
////        return users;
////    }
////
////    private User mapRowToUser(SqlRowSet rs) {
////        Transfer transfer = new Transfer();
////        transfer.setTranferId(rs.getInt("transfer_id"));
////        transfer.setUsername(rs.getString("transfer_type_desc"));
////        transfer.setPassword(rs.getString("transfer_status_desc"));
////        transfer.setActivated(true);
////        transfer.setAuthorities("USER");
////        return user;
////    }
//}
