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

public class ClienteDtoSaida {
    private UUID id;
    private String nome;
    private String cpf;
    private Long idade;
    private String telefone;
    private List<VendaEntity> vendas;
}
