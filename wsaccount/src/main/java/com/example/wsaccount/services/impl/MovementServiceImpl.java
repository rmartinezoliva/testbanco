package com.example.wsaccount.services.impl;

import com.example.wsaccount.dtos.request.MovementCreateRequest;
import com.example.wsaccount.exceptions.AccountNotFoundExcepcion;
import com.example.wsaccount.exceptions.InsufficientBalanceException;
import com.example.wsaccount.mappers.MovementMapper;
import com.example.wsaccount.models.Account;
import com.example.wsaccount.models.Movement;
import com.example.wsaccount.repositories.AccountRepository;
import com.example.wsaccount.repositories.MovementRepository;
import com.example.wsaccount.services.MovementService;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Data
@NoArgsConstructor
public class MovementServiceImpl implements MovementService {

    @Autowired
    private MovementRepository movementRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MovementMapper mapper;

    @Override
    public Movement save(MovementCreateRequest request) {

        Account acount = accountRepository.findById(request.getAccountid()).orElseThrow(() -> new AccountNotFoundExcepcion("Account ["+request.getAccountid()+"] not found"));

        acount.setSaldoInicial(calcularAjuste(acount.getSaldoInicial() , request.getValor()));

        if(acount.getSaldoInicial()<0) {
            throw new InsufficientBalanceException();
        }

        accountRepository.save(acount);

        Movement movement = mapper.toModel(request);
        movement.setAccount(acount);
        movement.setSaldo(acount.getSaldoInicial());

        return movementRepository.save(movement);
    }

    @Override
    public void deleteById(UUID id) {
        Movement movement =movementRepository.findById(id).orElse(null);
        if(movement == null){
            throw new AccountNotFoundExcepcion("Movement ["+id+"] not found");
        }
        movementRepository.deleteById(id);
    }

    @Override
    public Movement update(UUID id, Movement movementAux) {
        Movement movement =movementRepository.findById(id).orElse(null);
        if(movement == null){
            throw new AccountNotFoundExcepcion("Client ["+id+"] not found");
        }
        movement = mapper.updateMovementFromMovementAux(movementAux,movement);
        movementRepository.save(movement);
        return movement;
    }

    @Override
    public List<Movement> getReport(String fecha, String accountId) {

        String[] fechas = fecha.split(",");


        LocalDateTime fechaInicioDateTime;
        LocalDateTime fechaFinDateTime;
        try {
            LocalDate fechaInicio = LocalDate.parse(fechas[0]);
            LocalDate fechaFin = LocalDate.parse(fechas[1]);

            fechaInicioDateTime = fechaInicio.atStartOfDay();
            fechaFinDateTime = fechaFin.atTime(23, 59, 59);
        } catch (Exception e) {
            throw new IllegalArgumentException("Fecha invalida");
        }

        Account account = accountRepository.findById(UUID.fromString(accountId)).orElseThrow(() -> new AccountNotFoundExcepcion("Account ["+accountId+"] not found"));
        return movementRepository.findByAccountIdAndFechaBetween(
                UUID.fromString(accountId), fechaInicioDateTime, fechaFinDateTime);
    }

    private double calcularAjuste(double saldo, double valor) {
        return valor < 0 ? saldo-valor : saldo + valor;
    }

}
