package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;


    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(Integer userId) {
        BigDecimal balance = null;
        String sql = "SELECT balance FROM account WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if(results.next()){
                balance = results.getBigDecimal("balance");
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return balance;
    }

    @Override
    public List<User> getUsers(int id) {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username " +
                "FROM tenmo_user " +
                "WHERE user_id != ?";

        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            while(results.next()){
                User user = mapRowToUser(results);
                users.add(user);
            }
        }catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return users;
    }

    private User mapRowToUser(SqlRowSet results){
        User user = new User();
        user.setId(results.getInt("user_id"));
        user.setUsername(results.getString("username"));
        return user;
    }

}
