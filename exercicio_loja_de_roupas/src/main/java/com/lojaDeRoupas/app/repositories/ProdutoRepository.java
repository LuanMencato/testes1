package com.lojaDeRoupas.app.repositories;

import com.lojaDeRoupas.app.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    Optional<ProdutoEntity> findByNome(String nome);
    Optional<ProdutoEntity> findByValor(BigDecimal valor);
    @Query("SELECT p FROM ProdutoEntity p WHERE p.valor <= :maior AND p.valor >= :menor")
    ProdutoEntity buscarValorEntre(@RequestParam("maior") BigDecimal maior,
                                   @RequestParam("menor") BigDecimal menor);
}