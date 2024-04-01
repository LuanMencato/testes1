package com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses;

import com.lojaDeRoupas.app.coreClasses.ResponseWrapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class CrudGenericController <
        Entity extends CrudGenericEntity,
        Service extends CrudGenericService<Entity, Repository, DTOIn, DTOOut>,
        Repository extends org.springframework.data.jpa.repository.JpaRepository<Entity, UUID>,
        DTOIn extends CrudGenericDTOIn,
        DTOOut
        >{
    @Autowired
    Service service;
    @PostMapping(CrudGenericEndPointName.REGISTER)
    private ResponseEntity<ResponseWrapper<String>>
    register(@RequestBody @Valid DTOIn object){

        ResponseWrapper<String> response = new ResponseWrapper<>();

        try {
            response.setMessage(service.register(object));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.setErrors(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping(CrudGenericEndPointName.FIND)
    private ResponseEntity<ResponseWrapper<List<DTOOut>>>
    find(@RequestParam("quantity") Long quantity,
           @RequestParam("order") String order) {

        ResponseWrapper<List<DTOOut>> response = new ResponseWrapper<>();

        try {
            response.setObject(service.find(quantity, order));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.setErrors(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping(CrudGenericEndPointName.FIND_BY_ID)
    private ResponseEntity<ResponseWrapper<DTOOut>>
    findById(@RequestParam("id")UUID id) {

        ResponseWrapper<DTOOut> response = new ResponseWrapper<>();

        try {
            response.setObject(service.findById(id));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.setErrors(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @PutMapping(CrudGenericEndPointName.UPDATE)
    private ResponseEntity<ResponseWrapper<String>>
    update(@RequestBody @Valid DTOIn object) {

        ResponseWrapper<String> response = new ResponseWrapper<>();

        try {
            response.setMessage(service.update(object));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.setErrors(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @DeleteMapping(CrudGenericEndPointName.DELETE)
    private ResponseEntity<ResponseWrapper<String>>
    delete(@RequestParam("id") UUID id) {

        ResponseWrapper<String> response = new ResponseWrapper<>();

        try {
            response.setMessage(service.delete(id));
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.setErrors(e.getMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

}
