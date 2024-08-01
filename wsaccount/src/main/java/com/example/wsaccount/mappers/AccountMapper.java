package com.example.wsaccount.mappers;


import com.example.wsaccount.dtos.request.AccountCreateRequest;
import com.example.wsaccount.dtos.request.AccountUpdatePartialRequest;
import com.example.wsaccount.dtos.request.AccountUpdateRequest;
import com.example.wsaccount.dtos.response.AccountResponse;
import com.example.wsaccount.models.Account;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountMapper {

  Account toModel(AccountCreateRequest accountCreateRequest);

  Account toUpdateModel(AccountUpdateRequest accountUpdateRequest);
  Account toUpdatePartialModel(AccountUpdatePartialRequest accountUpdatePartialRequest);
  AccountResponse toResponse(Account account);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Account updateAccountFromAccountAux(Account account, @MappingTarget Account accountAux);
}
