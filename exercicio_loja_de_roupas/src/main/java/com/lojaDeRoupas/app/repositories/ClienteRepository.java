package com.lojaDeRoupas.app.repositories;

import com.lojaDeRoupas.app.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
    ClienteEntity findByTelefone(String telefone);
    ClienteEntity findByCpf(String cpf);
    boolean existsByCpf(String cpf);
}
