package com.example.wsaccount.controllers;

import com.example.wsaccount.dtos.request.AccountCreateRequest;
import com.example.wsaccount.dtos.request.MovementCreateRequest;
import com.example.wsaccount.dtos.response.AccountResponse;
import com.example.wsaccount.dtos.response.MovementResponse;
import com.example.wsaccount.mappers.MovementMapper;
import com.example.wsaccount.services.AccountService;
import com.example.wsaccount.services.MovementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Api movimientos V1", description = "Api movimientos V1")
@CrossOrigin(origins = "*")
@RestController("/movimientos.v1.crud")
@RequestMapping("/movimientos")
public class MovementController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private MovementMapper mapper;

    @PostMapping
    public ResponseEntity<MovementResponse> create(@Valid @RequestBody MovementCreateRequest movementCreateRequest) {
           return new ResponseEntity<>(mapper.toResponse(movementService.save(movementCreateRequest)), HttpStatus.CREATED);
    }

}
