package com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses;

import com.lojaDeRoupas.app.config.messageHandling.errorMessages.ExceptionMessages;
import com.lojaDeRoupas.app.config.messageHandling.successMessages.SuccessMessages;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

@Transactional
public abstract class CrudGenericService<
        Entity extends CrudGenericEntity,
        Repository extends JpaRepository<Entity, UUID>,
        DTOIn extends CrudGenericDTOIn,
        DTOOut
        > implements CrudStandardServiceMethods<
        Entity,
        DTOIn,
        DTOOut>{
    @Autowired
    private Repository repository;
    @Autowired
    private ModelMapper modelMapper;
    public String genericRegister(
            DTOIn objectIn,
            Class<Entity> entityClass
    ) throws Exception {

        /*
        * Get the ID if this entity already exists but has been deactivated
        * */
        this.verifications(objectIn);
        Entity entityToPersist = modelMapper.map(objectIn, entityClass);

        this.handleRelatedEntities(entityToPersist);
        this.applyBusinessRules(entityToPersist);

        repository.save(entityToPersist);

        return SuccessMessages.CREATED;
    }
    public DTOOut genericFindById(UUID id,
                                    Class<DTOOut> dtoOutClass)
            throws Exception {

        if(!this.repository.existsById(id))
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        Entity entity = this.repository.getReferenceById(id);

        if(!entity.isStatus())
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        return modelMapper.map(entity, dtoOutClass);
    }
    public List<DTOOut> genericFind(Long quantity,
                                    String order,
                                    Class<DTOOut> dtoOutClass)
            throws EntityNotFoundException {

        List<Entity> entities;

        if(order != null && order.equals("DESC"))
            entities = this.repository.findAll(Sort.by(Sort.Direction.DESC));
        else
            entities = this.repository.findAll();

        if(entities.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.LIST_NOT_FOUND);

        List<Entity> entityList = new ArrayList<>();
        for(int i = 0; i < quantity && i < entities.size(); i++){
            if(entities.get(i).isStatus()){
                entityList.add(entities.get(i));
            }
        }

        if(entityList.isEmpty())
            throw new EntityNotFoundException(ExceptionMessages.LIST_NOT_FOUND);

        List<DTOOut> dtoOuts = new ArrayList<>();
        entityList.forEach(e -> {
            dtoOuts.add(modelMapper.map(e, dtoOutClass));
        });

        return dtoOuts;
    }
    public String genericUpdate(DTOIn objectIn,
                                Class<Entity> entityClass)
            throws EntityNotFoundException {

        if(!repository.existsById(objectIn.getId()))
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        Entity entity = repository.getReferenceById(objectIn.getId());

        if(!entity.isStatus())
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        Entity entityToSave = modelMapper.map(objectIn, entityClass);
        entityToSave.setStatus(entity.isStatus());
        repository.save(entityToSave);

        return SuccessMessages.UPDATED;
    }
    public String genericDelete(UUID uuid)
            throws EntityNotFoundException {

        if(!repository.existsById(uuid))
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        Entity entity = repository.getReferenceById(uuid);

        if(!entity.isStatus())
            throw new EntityNotFoundException(ExceptionMessages.ENTITY_NOT_FOUND);

        entity.setStatus(false);
        repository.save(entity);

        return SuccessMessages.DELETED;
    }
}
