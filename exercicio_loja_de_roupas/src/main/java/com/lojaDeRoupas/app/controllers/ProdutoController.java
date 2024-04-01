package com.lojaDeRoupas.app.controllers;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericController;
import com.lojaDeRoupas.app.dtos.dtoEntrada.ProdutoDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.ProdutoDtoSaida;
import com.lojaDeRoupas.app.entities.ProdutoEntity;
import com.lojaDeRoupas.app.repositories.ProdutoRepository;
import com.lojaDeRoupas.app.service.ProdutoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends CrudGenericController<
        ProdutoEntity,
        ProdutoService,
        ProdutoRepository,
        ProdutoDtoEntrada,
        ProdutoDtoSaida> {
}
