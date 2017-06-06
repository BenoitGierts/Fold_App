package com.foldapp.hcattiaux.foldapp;

/**
 * Created by hcattiaux on 22/02/17.
 */

public class Logement {

    private int IdLogement;
    private int TypeLogement;
    private String TitreLogement;
    private String NbPiece;
    private String NbChambre;
    private int Surface;
    private String Prix;
    private String NbEtage;
    private int TypeChauffage;
    private int IdProprietaire;
    private int IdCommodite;
    private int IdLocalisation;
    private String description;
    private String image;


    public Logement(){}

    public Logement( int IdLogement, int TypeLogement,String TitreLogement, String NbPiece, String NbChambre, int Surface, String Prix , String NbEtage, int Ascenseur, int Renove, int TypeChauffage, int IdProprietaire, int IdCommodite, int IdLocalisation, String description, String image ){

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
        this.description     =  description;
        this.image           =  image;
    }

    public Logement(String TitreLogement, String Prix, String description, String NbChambre, String NbEtage, String NbPiece, String image ){

        this.TitreLogement   =  TitreLogement;
        this.Prix            =  Prix;
        this.description     =  description;
        this.NbChambre       =  NbChambre;
        this.NbEtage         =  NbEtage;
        this.NbPiece         =  NbPiece;
        this.image           =  image;
    }




    public int getIdLogement() {
        return IdLogement;
    }

    public void setIdLogement(int idLogement) {
        IdLogement = idLogement;
    }

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

    public String getNbPiece() {
        return NbPiece;
    }

    public void setNbPiece(String nbPiece) {
        NbPiece = nbPiece;
    }

    public String getNbChambre() {
        return NbChambre;
    }

    public void setNbChambre(String nbChambre) {
        NbChambre = nbChambre;
    }

    public int getSurface() {
        return Surface;
    }

    public void setSurface(int surface) {
        Surface = surface;
    }

    public String getPrix() {
        return Prix;
    }

    public void setPrix(String prix) {
        Prix = prix;
    }

    public String getNbEtage() {
        return NbEtage;
    }

    public void setNbEtage(String nbEtage) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String toString(){
        return "IdLogement : "+IdLogement+"\nTitreLogement : "+TitreLogement+"\nPrix : "+Prix;
    }
}