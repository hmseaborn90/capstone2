package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDetail;

import java.util.List;

public interface TransferDao {
    List<Transfer> getTransfers(int userId);

    TransferDetail getTransferDetails(int transferId);
}
