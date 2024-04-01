package com.lojaDeRoupas.app.service;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericService;
import com.lojaDeRoupas.app.dtos.dtoEntrada.ProdutoDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoEntrada.VendaDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.ProdutoDtoSaida;
import com.lojaDeRoupas.app.dtos.dtoSaida.VendaDtoSaida;
import com.lojaDeRoupas.app.entities.ProdutoEntity;
import com.lojaDeRoupas.app.entities.VendaEntity;
import com.lojaDeRoupas.app.repositories.VendaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class VendaService extends CrudGenericService<
        VendaEntity,
        VendaRepository,
        VendaDtoEntrada,
        VendaDtoSaida> {
    @Override
    public String register(VendaDtoEntrada objectIn) throws Exception {
        return genericRegister(objectIn, VendaEntity.class);
    }

    @Override
    public List<VendaDtoSaida> find(Long quantity, String order) throws Exception {
        return genericFind(quantity, order, VendaDtoSaida.class);
    }

    @Override
    public VendaDtoSaida findById(UUID id) throws Exception {
        return genericFindById(id, VendaDtoSaida.class);
    }

    @Override
    public String update(VendaDtoEntrada objectIn) throws Exception {
        return genericUpdate(objectIn, VendaEntity.class);
    }

    @Override
    public String delete(UUID uuid) throws Exception {
        return genericDelete(uuid);
    }

    @Override
    public void verifications(VendaDtoEntrada objectIn) throws Exception {
    }

    @Override
    public void handleRelatedEntities(VendaEntity entityToPersist) {
    }

    @Override
    public void applyBusinessRules(VendaEntity entityToPersist) {
    }

    private String verificarStatus(VendaEntity venda) {
        if ("CANCELADO".equalsIgnoreCase(venda.getStatus())) {
            venda.setProdutos(null);
            venda.setValorTotal(BigDecimal.ZERO);
        }
        return venda.getValorTotal() + " atualizado";
    }

    public double calcularValorTotal(List<ProdutoEntity> produtos) {
        double total = 0;
        for (ProdutoEntity produto : produtos) {
            total += produto.getValor() * produto.getQuantidade();
        }
        return total;
    }
}
