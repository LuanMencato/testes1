package com.lojaDeRoupas.app.entities;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "venda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaEntity extends CrudGenericEntity {
    @Column
    private String enderecoDaEntrega;
    @Column(nullable = false)
    private BigDecimal valorTotal;
    @ManyToOne(cascade = CascadeType.ALL)
    private ClienteEntity cliente;
    @NotBlank
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private FuncionarioEntity funcionario;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ProdutoEntity> produtos;
}
