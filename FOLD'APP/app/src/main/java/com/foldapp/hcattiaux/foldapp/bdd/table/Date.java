package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 17/03/17.
 */

public class Date {

    private static  int DateJulien;
    private static  int Heure;
    private static  int IdDate;



    public Date(int DateJulien, int Heure, int IdDate ){

        this.DateJulien     =  DateJulien;
        this.Heure          =  Heure;
        this.IdDate         =  IdDate;


    }


    public static int getDateJulien() {
        return DateJulien;
    }

    public static void setDateJulien(int dateJulien) {
        DateJulien = dateJulien;
    }

    public static int getHeure() {
        return Heure;
    }

    public static void setHeure(int heure) {
        Heure = heure;
    }

    public static int getIdDate() {
        return IdDate;
    }

    public static void setIdDate(int idDate) {
        IdDate = idDate;
    }

    public String toString(){
        return "IdDate : "+IdDate+"\n DateJulien : "+DateJulien+"\n Heure : "+Heure;
    }


}
