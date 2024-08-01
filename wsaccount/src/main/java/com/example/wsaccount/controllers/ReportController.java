package com.example.wsaccount.controllers;

import com.example.wsaccount.dtos.request.AccountCreateRequest;
import com.example.wsaccount.dtos.request.AccountUpdatePartialRequest;
import com.example.wsaccount.dtos.request.AccountUpdateRequest;
import com.example.wsaccount.dtos.response.AccountResponse;
import com.example.wsaccount.mappers.AccountMapper;
import com.example.wsaccount.models.Movement;
import com.example.wsaccount.services.AccountService;
import com.example.wsaccount.services.MovementService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Api reportes  V1", description = "Api reportes V1")
@CrossOrigin(origins = "*")
@RestController("/reportes.v1.crud")
@RequestMapping("/reportes")
public class ReportController {

    @Autowired
    private MovementService movementService;

    @Autowired
    private AccountMapper mapper;

    @GetMapping
    public ResponseEntity<List<Movement>> create(@RequestParam("fecha") String fecha, @RequestParam("accountId") String accountId) {
           return new ResponseEntity<>(movementService.getReport(fecha, accountId), HttpStatus.CREATED);
    }

}
