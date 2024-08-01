package com.example.wsaccount.services;

import com.example.wsaccount.dtos.request.MovementCreateRequest;
import com.example.wsaccount.models.Movement;

import java.util.List;
import java.util.UUID;

public interface MovementService {
    public Movement save(MovementCreateRequest movementCreateRequest);
    public void deleteById(UUID id);
    public Movement update(UUID id, Movement movement);

    public List<Movement> getReport(String fecha, String accountId);

}
