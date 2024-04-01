package com.lojaDeRoupas.app.dtos.dtoSaida;

import com.lojaDeRoupas.app.entities.ClienteEntity;
import com.lojaDeRoupas.app.entities.FuncionarioEntity;
import com.lojaDeRoupas.app.entities.ProdutoEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaDtoSaida {
    private UUID id;
    private String enderecoDaEntrega;
    private BigDecimal valorTotal;
    private ClienteEntity cliente;
    private FuncionarioEntity funcionario;
    private List<ProdutoEntity> produtos;
}
