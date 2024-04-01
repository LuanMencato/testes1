package com.lojaDeRoupas.app.controllers;

import com.lojaDeRoupas.app.coreClasses.ResponseWrapper;
import com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses.CrudGenericController;
import com.lojaDeRoupas.app.dtos.dtoEntrada.ClienteDtoEntrada;
import com.lojaDeRoupas.app.dtos.dtoSaida.ClienteDtoSaida;
import com.lojaDeRoupas.app.entities.ClienteEntity;
import com.lojaDeRoupas.app.repositories.ClienteRepository;
import com.lojaDeRoupas.app.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends CrudGenericController<
        ClienteEntity,
        ClienteService,
        ClienteRepository,
        ClienteDtoEntrada,
        ClienteDtoSaida> {
//    public ResponseEntity<ResponseWrapper<ClienteDtoSaida>>
//    buscarPorEndereco(@RequestParam("endereco") String endereco){
//
//    }
}
