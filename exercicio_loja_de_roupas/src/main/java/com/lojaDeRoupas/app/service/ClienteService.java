package com.lojaDeRoupas.app.service;

import com.lojaDeRoupas.app.config.messageHandling.errorMessages.ExceptionMessages;
import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericService;
import com.lojaDeRoupas.app.dtos.dtoEntrada.ClienteDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.ClienteDtoSaida;
import com.lojaDeRoupas.app.entities.ClienteEntity;
import com.lojaDeRoupas.app.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class ClienteService extends CrudGenericService<
        ClienteEntity,
        ClienteRepository,
        ClienteDtoEntrada,
        ClienteDtoSaida> {
    @Autowired
    ClienteRepository repository;
    @Override
    public String register(ClienteDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, ClienteEntity.class);
    }

    @Override
    public List<ClienteDtoSaida> find(Long quantity, String order) throws Exception {
        return genericFind(quantity, order, ClienteDtoSaida.class);
    }

    @Override
    public ClienteDtoSaida findById(UUID id) throws Exception {
        return genericFindById(id, ClienteDtoSaida.class);
    }

    @Override
    public String update(ClienteDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, ClienteEntity.class);
    }

    @Override
    public String delete(UUID uuid) throws Exception {
        return genericDelete(uuid);
    }

    @Override
    public void verifications(ClienteDtoEntrada objectIn) throws Exception {
        if(repository.existsByCpf(objectIn.getCpf())){
            throw new Exception(ExceptionMessages.CPF_ALREADY_IN_USE);
        }
    }

    @Override
    public void handleRelatedEntities(ClienteEntity entityToPersist) {
    }

    @Override
    public void applyBusinessRules(ClienteEntity entityToPersist) {
    }
}
