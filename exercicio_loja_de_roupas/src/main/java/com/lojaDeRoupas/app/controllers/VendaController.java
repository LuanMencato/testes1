package com.lojaDeRoupas.app.controllers;

import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericController;
import com.lojaDeRoupas.app.dtos.dtoEntrada.VendaDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.VendaDtoSaida;
import com.lojaDeRoupas.app.entities.VendaEntity;
import com.lojaDeRoupas.app.repositories.VendaRepository;
import com.lojaDeRoupas.app.service.VendaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venda")
public class VendaController extends CrudGenericController<
        VendaEntity,
        VendaService,
        VendaRepository,
        VendaDtoEntrada,
        VendaDtoSaida> {
}
