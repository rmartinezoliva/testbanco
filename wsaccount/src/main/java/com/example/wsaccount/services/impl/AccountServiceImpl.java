package com.example.wsaccount.services.impl;

import com.example.wsaccount.exceptions.AccountNotFoundExcepcion;
import com.example.wsaccount.mappers.AccountMapper;
import com.example.wsaccount.models.Account;
import com.example.wsaccount.repositories.AccountRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Data
@NoArgsConstructor
public class AccountServiceImpl implements com.example.wsaccount.services.AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper mapper;

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(UUID id) {
        Account account =accountRepository.findById(id).orElse(null);
        if(account == null){
            throw new AccountNotFoundExcepcion("Account ["+id+"] not found");
        }
        accountRepository.deleteById(id);
    }

    @Override
    public Account update(UUID id, Account accountAux) {
        Account account =accountRepository.findById(id).orElse(null);
        if(account == null){
            throw new AccountNotFoundExcepcion("Client ["+id+"] not found");
        }
        account = mapper.updateAccountFromAccountAux(accountAux,account);
        accountRepository.save(account);
        return account;
    }

}
