package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 17/03/17.
 */

public class Proprietaire {

    private String Nom;
    private String Prenom;
    private String Telephone;
    private String Email;
    private int Sexe;
    private String IdLogement;
    private String IdProprietaire;




    public Proprietaire(String Nom, String Prenom, String Telephone, String Email, int Sexe, String IdLogement, String IdProprietaire     ){

        this.Nom      =  Nom;
        this.Prenom    =  Prenom;
        this.Telephone      =  Telephone;
        this.Email    =  Email;
        this.Sexe      =  Sexe;
        this.IdLogement    =  IdLogement;
        this.Nom      =  Nom;
        this.IdProprietaire    =  IdProprietaire;

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public int getSexe() {
        return Sexe;
    }

    public void setSexe(int sexe) {
        Sexe = sexe;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getIdLogement() {
        return IdLogement;
    }

    public void setIdLogement(String idLogement) {
        IdLogement = idLogement;
    }

    public String getIdProprietaire() {
        return IdProprietaire;
    }

    public void setIdProprietaire(String idProprietaire) {
        IdProprietaire = idProprietaire;
    }

    public String toString(){
        return "IdProprietaire : "+IdProprietaire+"\n Nom : "+Nom+"\nPrenom : "+Prenom;
    }
}





