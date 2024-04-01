package com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses;

import java.util.List;
import java.util.UUID;

public interface CrudStandardServiceMethods<
        Entity extends CrudGenericEntity,
        DTOIn extends CrudGenericDTOIn,
        DTOOut
        >{
    String register(DTOIn objectIn) throws Exception;
    List<DTOOut> find(Long quantity, String order) throws Exception;
    DTOOut findById(UUID id) throws Exception;
    String update(DTOIn objectIn) throws Exception;
    String delete(UUID uuid) throws Exception;
    void verifications(DTOIn objectIn) throws Exception;
    void handleRelatedEntities(Entity entityToPersist);
    void applyBusinessRules(Entity entityToPersist);
}