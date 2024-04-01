package com.lojaDeRoupas.app.service;

import com.lojaDeRoupas.app.config.messageHandling.errorMessages.ExceptionMessages;
import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericService;
import com.lojaDeRoupas.app.dtos.dtoEntrada.FuncionarioDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.FuncionarioDtoSaida;
import com.lojaDeRoupas.app.entities.FuncionarioEntity;
import com.lojaDeRoupas.app.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class FuncionarioService extends CrudGenericService<
        FuncionarioEntity,
        FuncionarioRepository,
        FuncionarioDtoEntrada,
        FuncionarioDtoSaida> {
    @Autowired
    private FuncionarioRepository repository;
    @Override
    public String register(FuncionarioDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, FuncionarioEntity.class);
    }

    @Override
    public List<FuncionarioDtoSaida> find(Long quantity, String order) throws Exception {
        return genericFind(quantity, order, FuncionarioDtoSaida.class);
    }

    @Override
    public FuncionarioDtoSaida findById(UUID id) throws Exception {
        return genericFindById(id, FuncionarioDtoSaida.class);
    }

    @Override
    public String update(FuncionarioDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, FuncionarioEntity.class);
    }

    @Override
    public String delete(UUID uuid) throws Exception {
        return genericDelete(uuid);
    }

    @Override
    public void verifications(FuncionarioDtoEntrada objectIn) throws Exception {
        if(repository.existePorMatricula(objectIn.getMatricula()))
            throw new Exception(ExceptionMessages.IDENTIFIER_ALREADY_REGISTERED);
    }

    @Override
    public void handleRelatedEntities(FuncionarioEntity entityToPersist) {
    }

    @Override
    public void applyBusinessRules(FuncionarioEntity entityToPersist) {
    }
}
