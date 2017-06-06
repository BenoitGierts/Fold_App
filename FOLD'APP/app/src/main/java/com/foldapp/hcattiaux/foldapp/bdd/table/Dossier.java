package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 30/03/17.
 */

public class Dossier {

    private static  int IdDossier;
    private static  int TypeDossier;
    private static  int NomDossier;


    public static int getIdDossier() {
        return IdDossier;
    }

    public static void setIdDossier(int idDossier) {
        IdDossier = idDossier;
    }

    public static int getTypeDossier() {
        return TypeDossier;
    }

    public static void setTypeDossier(int typeDossier) {
        TypeDossier = typeDossier;
    }

    public static int getNomDossier() {
        return NomDossier;
    }

    public static void setNomDossier(int nomDossier) {
        NomDossier = nomDossier;
    }

    public Dossier(int DateJulien, int Heure, int IdDate ){

        this.IdDossier     =  IdDossier;
        this.TypeDossier   =  TypeDossier;
        this.NomDossier    =  NomDossier;


    }


    public String toString(){
        return "IdDossier : "+IdDossier+"\n NomDossier : "+NomDossier+"\n TypeDossier : "+TypeDossier;
    }


}
