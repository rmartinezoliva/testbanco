package com.example.wsclients.mappers;


import com.example.wsclients.dtos.request.ClientCreateRequest;
import com.example.wsclients.dtos.request.ClientUpdatePartialRequest;
import com.example.wsclients.dtos.request.ClientUpdateRequest;
import com.example.wsclients.dtos.response.ClientResponse;
import com.example.wsclients.models.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

  Client toModel(ClientCreateRequest clientCreateRequest);

  Client toUpdateModel(ClientUpdateRequest clientUpdateRequest);
  Client toUpdatePartialModel(ClientUpdatePartialRequest clientUpdatePartialRequest);
  ClientResponse toResponse(Client Client);

  List<ClientResponse> toResponseList(List<Client> clients);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Client updateClientFromClientAux(Client client, @MappingTarget Client clientAux);
}
