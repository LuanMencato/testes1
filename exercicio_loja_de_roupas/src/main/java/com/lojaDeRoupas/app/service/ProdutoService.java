package com.lojaDeRoupas.app.service;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericService;
import com.lojaDeRoupas.app.dtos.dtoEntrada.ProdutoDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.ProdutoDtoSaida;
import com.lojaDeRoupas.app.entities.ProdutoEntity;
import com.lojaDeRoupas.app.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProdutoService extends CrudGenericService<
        ProdutoEntity,
        ProdutoRepository,
        ProdutoDtoEntrada,
        ProdutoDtoSaida> {
    @Override
    public String register(ProdutoDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, ProdutoEntity.class);
    }

    @Override
    public List<ProdutoDtoSaida> find(Long quantity, String order) throws Exception {
        return genericFind(quantity, order, ProdutoDtoSaida.class);
    }

    @Override
    public ProdutoDtoSaida findById(UUID id) throws Exception {
        return genericFindById(id, ProdutoDtoSaida.class);
    }

    @Override
    public String update(ProdutoDtoEntrada objectIn) throws Exception {
        return genericUpdate(objectIn, ProdutoEntity.class);
    }

    @Override
    public String delete(UUID uuid) throws Exception {
        return genericDelete(uuid);
    }

    @Override
    public void verifications(ProdutoDtoEntrada objectIn) throws Exception {

    }

    @Override
    public void handleRelatedEntities(ProdutoEntity entityToPersist) {
    }

    @Override
    public void applyBusinessRules(ProdutoEntity entityToPersist) {
    }

}
