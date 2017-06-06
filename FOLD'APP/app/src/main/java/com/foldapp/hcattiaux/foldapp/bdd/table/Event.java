package com.foldapp.hcattiaux.foldapp.bdd.table;

/**
 * Created by bgierts on 17/03/17.
 */

public class Event {

    private static  String NomEvent;
    private static  String TypeEvent;
    private static  int IdDate;
    private static  int IdEvent;
    private static  int IdLogement;


    public Event(String NomEvent, String TypeEvent, int IdDate, int IdEvent, int IdLogement ){

        this.NomEvent           =  NomEvent;
        this.TypeEvent          =  TypeEvent;
        this.IdDate             =  IdDate;
        this.IdEvent            =  IdEvent;
        this.IdLogement         =  IdLogement;



    }


    public static String getNomEvent() {
        return NomEvent;
    }

    public static void setNomEvent(String nomEvent) {
        NomEvent = nomEvent;
    }

    public static String getTypeEvent() {
        return TypeEvent;
    }

    public static void setTypeEvent(String typeEvent) {
        TypeEvent = typeEvent;
    }

    public static int getIdDate() {
        return IdDate;
    }

    public static void setIdDate(int idDate) {
        IdDate = idDate;
    }

    public static int getIdEvent() {
        return IdEvent;
    }

    public static void setIdEvent(int idEvent) {
        IdEvent = idEvent;
    }

    public static int getIdLogement() {
        return IdLogement;
    }

    public static void setIdLogement(int idLogement) {
        IdLogement = idLogement;
    }

    public String toString(){
        return "IdEvent : "+IdEvent+"\n TypeEvent : "+TypeEvent+"\n NomEvent : "+NomEvent;
    }




}
