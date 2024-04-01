package com.lojaDeRoupas.app.controllers;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericController;
import com.lojaDeRoupas.app.dtos.dtoEntrada.FuncionarioDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.FuncionarioDtoSaida;
import com.lojaDeRoupas.app.entities.FuncionarioEntity;
import com.lojaDeRoupas.app.repositories.FuncionarioRepository;
import com.lojaDeRoupas.app.service.FuncionarioService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/funcionario")
public class FuncionarioController extends CrudGenericController<
        FuncionarioEntity,
        FuncionarioService,
        FuncionarioRepository,
        FuncionarioDtoEntrada,
        FuncionarioDtoSaida> {
}
