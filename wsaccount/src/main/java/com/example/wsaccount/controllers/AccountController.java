package com.example.wsaccount.controllers;

import com.example.wsaccount.dtos.request.AccountCreateRequest;
import com.example.wsaccount.dtos.request.AccountUpdatePartialRequest;
import com.example.wsaccount.dtos.request.AccountUpdateRequest;
import com.example.wsaccount.dtos.response.AccountResponse;
import com.example.wsaccount.mappers.AccountMapper;
import com.example.wsaccount.services.AccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Api cuentas V1", description = "Api cuentas V1")
@CrossOrigin(origins = "*")
@RestController("/cuentas.v1.crud")
@RequestMapping("/cuentas")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper mapper;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody AccountCreateRequest accountCreateRequest) {
           return new ResponseEntity<>(mapper.toResponse(accountService.save(mapper.toModel(accountCreateRequest))), HttpStatus.CREATED);
    }


    @DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID accountId) {
        accountService.deleteById(accountId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{accountId}")
    public ResponseEntity<AccountResponse> update(@PathVariable UUID accountId, @Valid @RequestBody AccountUpdateRequest accountUpdateRequest) {
        return new ResponseEntity<>(mapper.toResponse(accountService.update(accountId, mapper.toUpdateModel(accountUpdateRequest))), HttpStatus.OK);
    }

    @PatchMapping("/{accountId}")
    public ResponseEntity<AccountResponse> updatePartial(@PathVariable UUID accountId, @Valid @RequestBody AccountUpdatePartialRequest accountUpdatePartialRequest) {
        return new ResponseEntity<>(mapper.toResponse(accountService.update(accountId, mapper.toUpdatePartialModel(accountUpdatePartialRequest))), HttpStatus.OK);
    }
}
