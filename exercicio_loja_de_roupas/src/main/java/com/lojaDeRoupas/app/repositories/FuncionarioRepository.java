package com.lojaDeRoupas.app.repositories;

import com.lojaDeRoupas.app.entities.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, UUID> {
    Optional<FuncionarioEntity> findByNome(String nome);
    Optional<FuncionarioEntity> findByMatricula(Long matricula);
    @Query("SELECT COUNT(f) > 0 FROM FuncionarioEntity f WHERE f.matricula = :matricula")
    boolean existePorMatricula(Long matricula);
}
