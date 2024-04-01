package com.lojaDeRoupas.app.entities;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity extends CrudGenericEntity {
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 15, unique = true)
    private String cpf;
    @Column(nullable = false)
    private Long idade;
    @Column(nullable = false, length = 30)
    private String telefone;
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<VendaEntity> vendas;
}
