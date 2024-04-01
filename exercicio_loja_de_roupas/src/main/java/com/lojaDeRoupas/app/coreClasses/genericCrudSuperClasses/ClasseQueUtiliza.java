package com.lojaDeRoupas.app.coreClasses.genericCrudSuperClasses;

public class ClasseQueUtiliza <ObjetoQualquer extends ClasseComId>{
    private ObjetoQualquer objetoQualquer;
    public void usaId(){
        objetoQualquer.setNome("Samir");
        System.out.println(objetoQualquer.getNome());
    }
}
