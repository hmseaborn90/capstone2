package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDetail;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTransferDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Transfer> getTransfers(int userId) {
        List<Transfer> transfers = new ArrayList<>();
        String sql = "SELECT transfer_id, afu.username as account_from, atu.username as account_to, amount " +
                "FROM transfer " +
                "JOIN account af ON transfer.account_from = af.account_id " +
                "JOIN tenmo_user afu ON af.user_id = afu.user_id " +
                "JOIN account at ON transfer.account_to = at.account_id " +
                "JOIN tenmo_user atu ON at.user_id = atu.user_id " +
                "WHERE af.user_id = ? OR atu.user_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, userId);
            while (results.next()) {
                Transfer transfer = mapRowToTransfer(results);
                transfers.add(transfer);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return transfers;
    }

    @Override
    public TransferDetail getTransferDetails(int transferId) {
        TransferDetail transferDetail = null;
        String sql = "SELECT transfer_id, transfer_type_desc, transfer_status_desc, afu.username as account_from, atu.username as account_to, amount " +
                "FROM transfer " +
                "JOIN transfer_status USING(transfer_status_id) " +
                "JOIN transfer_type USING(transfer_type_id) " +
                "JOIN account af ON transfer.account_from = af.account_id " +
                "JOIN tenmo_user afu ON af.user_id = afu.user_id " +
                "JOIN account at ON transfer.account_to = at.account_id " +
                "JOIN tenmo_user atu ON at.user_id = atu.user_id " +
                "WHERE transfer_id = ?;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId);
            if (results.next()) {
                transferDetail = mapRowToTransferDetails(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return transferDetail;
    }


    private Transfer mapRowToTransfer(SqlRowSet rs) {
        Transfer transfer = new Transfer();
        transfer.setTranferId(rs.getInt("transfer_id"));
        transfer.setAccountFrom(rs.getString("account_from"));
        transfer.setAccountTo(rs.getString("account_to"));
        transfer.setAmount(rs.getBigDecimal("amount"));

        return transfer;
    }
    private TransferDetail mapRowToTransferDetails(SqlRowSet rs) {
        TransferDetail transferDetail = new TransferDetail();
        transferDetail.setTranferId(rs.getInt("transfer_id"));
        transferDetail.setTransferType(rs.getString("transfer_type_desc"));
        transferDetail.setTransferStatus(rs.getString("transfer_status_desc"));
        transferDetail.setAccountFrom(rs.getString("account_from"));
        transferDetail.setAccountTo(rs.getString("account_to"));
        transferDetail.setAmount(rs.getBigDecimal("amount"));
        return transferDetail;
    }
}
