package com.lojaDeRoupas.app.dtos.dtoSaida;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDtoSaida {
    private UUID id;
    private String nome;
    private BigDecimal valor;
}
