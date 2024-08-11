package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDetail;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    List<Transfer> getTransfers(int userId);

    TransferDetail getTransferDetails(int transferId);

    TransferDetail sendRequest(int accountFrom, int accountTo, BigDecimal ammount);
}
