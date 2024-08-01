package com.example.wsaccount.mappers;


import com.example.wsaccount.dtos.request.AccountUpdatePartialRequest;
import com.example.wsaccount.dtos.request.AccountUpdateRequest;
import com.example.wsaccount.dtos.request.MovementCreateRequest;
import com.example.wsaccount.dtos.response.MovementResponse;
import com.example.wsaccount.models.Movement;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MovementMapper {

  Movement toModel(MovementCreateRequest movementCreateRequest);

  Movement toUpdateModel(AccountUpdateRequest accountUpdateRequest);
  Movement toUpdatePartialModel(AccountUpdatePartialRequest accountUpdatePartialRequest);
  MovementResponse toResponse(Movement movement);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Movement updateMovementFromMovementAux(Movement Movement, @MappingTarget Movement movementAux);
}
