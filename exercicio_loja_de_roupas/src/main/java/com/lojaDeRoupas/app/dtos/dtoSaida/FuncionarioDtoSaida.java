package com.lojaDeRoupas.app.dtos.dtoSaida;

import com.lojaDeRoupas.app.entities.VendaEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDtoSaida {
    private UUID id;
    private String nome;
    private Long idade;
    private Long matricula;
    private List<VendaEntity> vendas;
}
