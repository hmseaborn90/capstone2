package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/account/")
public class AccountController {

    private AccountDao accountDao;

    @Autowired
    public AccountController(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @GetMapping("balance/{id}")
    public BigDecimal getBalance(@PathVariable("id") Integer accountId){
        return accountDao.getBalance(accountId);
    }
}
