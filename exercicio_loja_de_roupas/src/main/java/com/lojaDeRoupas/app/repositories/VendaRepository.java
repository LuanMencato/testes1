package com.lojaDeRoupas.app.repositories;

import com.lojaDeRoupas.app.entities.VendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VendaRepository extends JpaRepository<VendaEntity, UUID> {
    boolean existsByEnderecoDaEntrega(String endereco);
    Optional<VendaEntity> findByEnderecoDaEntrega(String endereco);
    @Query("SELECT v FROM VendaEntity v WHERE v.enderecoDaEntrega LIKE %:endereco%")
    List<VendaEntity> procurarPorEndereco(@Param("endereco") String endereco);
    List<VendaEntity> findByStatusCancelled();

    List<VendaEntity> findByStatus(String status);

    List<VendaEntity> findByValorTotalBetween(BigDecimal minValue, BigDecimal maxValue);

}
