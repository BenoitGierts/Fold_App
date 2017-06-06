package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 10/03/17.
 */

public class Logement {

    private int IdLogement;
    private int IdDossier;
    private int TypeLogement;
    private String TitreLogement;
    private int NbPiece;
    private int NbChambre;
    private int Surface;
    private int Prix;
    private int NbEtage;
    private int TypeChauffage;
    private int IdProprietaire;
    private int IdCommodite;
    private int IdLocalisation;


    public Logement(){}

    public Logement( int IdLogement, int IdDossier, int TypeLogement,String TitreLogement, int NbPiece, int NbChambre, int Surface,int Prix , int NbEtage, int Ascenseur, int Renove, int TypeChauffage, int IdProprietaire, int IdCommodite, int IdLocalisation ){

        this.IdDossier       =  IdDossier;
        this.IdLogement      =  IdLogement;
        this.TypeLogement    =  TypeLogement;
        this.TitreLogement   =  TitreLogement;
        this.NbPiece         =  NbPiece;
        this.NbChambre       =  NbChambre;
        this.Surface         =  Surface;
        this.Prix            =  Prix;
        this.NbEtage         =  NbEtage;
        this.TypeChauffage   =  TypeChauffage;
        this.IdProprietaire  =  IdProprietaire;
        this.IdCommodite     =  IdCommodite;
        this.IdLocalisation  =  IdLocalisation;
    }

    public int getIdLogement() {
        return IdLogement;
    }

    public void setIdLogement(int idLogement) {
        IdLogement = idLogement;
    }

    public int getIdDossier() { return IdDossier; }

    public void setIdDossier(int idDossier) { IdDossier = idDossier; }

    public int getTypeLogement() {
        return TypeLogement;
    }

    public void setTypeLogement(int typeLogement) {
        TypeLogement = typeLogement;
    }

    public String getTitreLogement() {
        return TitreLogement;
    }

    public void setTitreLogement(String titreLogement) {
        TitreLogement = titreLogement;
    }

    public int getNbPiece() {
        return NbPiece;
    }

    public void setNbPiece(int nbPiece) {
        NbPiece = nbPiece;
    }

    public int getNbChambre() {
        return NbChambre;
    }

    public void setNbChambre(int nbChambre) {
        NbChambre = nbChambre;
    }

    public int getSurface() {
        return Surface;
    }

    public void setSurface(int surface) {
        Surface = surface;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int prix) {
        Prix = prix;
    }

    public int getNbEtage() {
        return NbEtage;
    }

    public void setNbEtage(int nbEtage) {
        NbEtage = nbEtage;
    }

    public int getTypeChauffage() {
        return TypeChauffage;
    }

    public void setTypeChauffage(int typeChauffage) {
        TypeChauffage = typeChauffage;
    }

    public int getIdProprietaire() {
        return IdProprietaire;
    }

    public void setIdProprietaire(int idProprietaire) {
        IdProprietaire = idProprietaire;
    }

    public int getIdCommodite() {
        return IdCommodite;
    }

    public void setIdCommodite(int idCommodite) {
        IdCommodite = idCommodite;
    }

    public int getIdLocalisation() {
        return IdLocalisation;
    }

    public void setIdLocalisation(int idLocalisation) {
        IdLocalisation = idLocalisation;
    }

    public String toString(){
        return "IdLogement : "+IdLogement+"\nTitreLogement : "+TitreLogement+"\nPrix : "+Prix;
    }
}