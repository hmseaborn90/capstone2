package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class JdbcAccountDao implements AccountDao{

    private final JdbcTemplate jdbcTemplate;


    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(Integer accountId) {
        BigDecimal balance = null;
        String sql = "SELECT balance FROM account WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
            if(results.next()){
                balance = results.getBigDecimal("balance");
            }
        } catch (CannotGetJdbcConnectionException e){
            throw new DaoException("Unable to connect to server or database", e);
        }
        return balance;
    }
}
