package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDetail;
import com.techelevator.tenmo.model.TransferPendingDto;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {
    List<Transfer> getTransfers(int userId);

    TransferDetail getTransferDetails(int transferId);

    TransferDetail sendRequest(int accountFrom, int accountTo, BigDecimal ammount);

    List<TransferPendingDto> getPendingTransfers(int userId);
}
