package com.example.wsaccount.repositories;

import com.example.wsaccount.models.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface MovementRepository extends JpaRepository<Movement, UUID> {
    @Query("SELECT m FROM Movement m WHERE m.account.id = :accountId AND m.fecha BETWEEN :fechaInicio AND :fechaFin")
    List<Movement> findByAccountIdAndFechaBetween(@Param("accountId") UUID accountId,
                                                  @Param("fechaInicio") LocalDateTime fechaInicio,
                                                  @Param("fechaFin") LocalDateTime fechaFin);
}