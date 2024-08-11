package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.TransferDetail;
import com.techelevator.tenmo.model.TransferRequest;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(path = "/transfer")
@PreAuthorize("isAuthenticated()")
public class TransferController {

    private TransferDao transferDao;
    private UserDao userDao;
    private AccountDao accountDao;

   @Autowired
    public TransferController(TransferDao transferDao, UserDao userDao, AccountDao accountDao) {
        this.transferDao = transferDao;
        this.userDao = userDao;
        this.accountDao = accountDao;
    }

    @GetMapping
    public List<Transfer> getTransfers(Principal principal){
       User user = userDao.getUserByUsername(principal.getName());
       return transferDao.getTransfers(user.getId());
    }

    @GetMapping(path = "/{id}")
    public TransferDetail getTransferDetails(@PathVariable int id){
       return transferDao.getTransferDetails(id);
    }

    @PostMapping("/request")
    public TransferDetail postTransferRequest(Principal principal, @RequestBody TransferRequest transferRequest){
        User user = userDao.getUserByUsername(principal.getName());
        int accountFrom = accountDao.getAccountByUserId(user.getId());
       return transferDao.sendRequest(accountFrom, transferRequest.getAccountTo(), transferRequest.getAmount());

    }
}
