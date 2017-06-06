package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 17/03/17.
 */

public class Localisation {

    private static  String Ville;
    private static  String Adresse;
    private static  int IdLocalisation;


    public Localisation(String Ville, String Adresse, int IdLocalisation ){

        this.Ville               =  Ville;
        this.Adresse             =  Adresse;
        this.IdLocalisation      =  IdLocalisation;


    }


    public static String getVille() {
        return Ville;
    }

    public static void setVille(String ville) {
        Ville = ville;
    }

    public static String getAdresse() {
        return Adresse;
    }

    public static void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public static int getIdLocalisation() {
        return IdLocalisation;
    }

    public static void setIdLocalisation(int idLocalisation) {
        IdLocalisation = idLocalisation;
    }

    public String toString(){
        return "IdLocalisation : "+IdLocalisation+"\n Ville : "+Ville+"\n Adresse : "+Adresse;
    }

}

