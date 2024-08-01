package com.example.wsaccount.services;


import com.example.wsaccount.models.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    public Account save(Account account);
    public void deleteById(UUID id);
    public Account update(UUID id, Account account);

}
