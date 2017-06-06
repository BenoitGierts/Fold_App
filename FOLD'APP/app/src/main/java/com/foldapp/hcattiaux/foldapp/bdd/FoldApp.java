package com.foldapp.hcattiaux.foldapp.bdd;

/**
 * Created by bgierts on 10/03/17.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.foldapp.hcattiaux.foldapp.bdd.table.Logement;

public class FoldApp {

    private static final int VERSION_BDD = 1;
    private static final String NOM_BDD = "foldapp.db";

    private static final String TableLogement = "Logement";
    private static final String TableProprietaire = "Proprietaire";
    private static final String TableEvent = "Event";
    private static final String TableDate = "Date";
    private static final String TableCommodite = "Commodite";
    private static final String TableLocalisation = "Localisation";
    private static final String TableDossier ="Dossier";


/***COLONNE***/


    /****COMMUN****/
    private static final String COL_IdLogement = "IdLogement";
    private static final String COL_IdProprietaire = "IdProprietaire";
    private static final String COL_IdCommodite = "IdCommodite";
    private static final String COL_IdLocalisation ="IdLocalisation";
    private static final String COL_IdDate ="IdDate";
    private static final String COL_IdEvent ="IdEvent";
    private static final String COL_IdDossier ="IdDossier";


    /*********LOGEMENT *************/
   // private static final String COL_IdLogement = "IdLogement";
    private static final int NUM_COL_IdLogement = 0;
    private static final String COL_TypeLogement = "TypeLogement";
    private static final int NUM_COL_TypeLogement = 1;
    private static final String COL_TitreLogement = "TitreLogement";
    private static final int NUM_COL_TitreLogement = 2;
    private static final String COL_NbPiece = "NbPiece";
    private static final int NUM_COL_NbPiece= 3;
    private static final String COL_NbChambre = "NbChambre";
    private static final int NUM_COL_NbChambre = 4;
    private static final String COL_Surface = "Surface";
    private static final int NUM_COL_Surface = 5;
    private static final String COL_Prix = "Prix";
    private static final int NUM_COL_Prix = 6;
    private static final String COL_NbEtage = "NbEtage";
    private static final int NUM_COL_NbEtage = 7;
    private static final String COL_TypeChauffage = "TypeChauffage";
    private static final int NUM_COL_TypeChauffage = 8;
   // private static final String COL_IdProprietaire = "IdProprietaire";
    private static final int NUM_COL_IdProprietaire = 9;
   // private static final String COL_IdCommodite = "IdCommodite";
    private static final int NUM_COL_IdCommodite= 10;
    //private static final String COL_IdEvent ="IdLocalisation";
    //private static final String COL_IdLogement = "IdLogement";
    //private static final String COL_IdProprietaire = "IdProprietaire";
    //private static final String COL_IdCommodite = "IdCommodite";
    //private static final String COL_IdDossier ="IdDossier";

    /****PROPRIETAIRE****/
    private static final String COL_Nom = "Nom";
    private static final String COL_Prenom = "Prenom";
    private static final String COL_Telephone = "Telephone";
    private static final String COL_Email = "Email";
    private static final String COL_Sexe = "Sexe";
    //private static final String COL_IdProprietaire = "IdProprietaire";
    //private static final String COL_IdLogement = "IdLogement";

    /****DATE***/
    private static final String COL_DateJulien = "DateJulien";
    private static final String COL_Heure = "Heure";
    /// private static final String COL_IdDate ="IdDate";

    /****EVENT****/
    private static final String COL_NomEvent = "NomEvent" ;
    private static final String COL_TypeEvent = "TypeEvent";
    /// private static final String COL_IdDate ="IdDate";
    //  private static final String COL_IdEvent ="IdEvent";
    // private static final String COL_IdLogement = "IdLogement";

    /***COMMODITE****/
    private static final String COL_Commodite1 = "Commodite1";
    private static final String COL_Commodite2 = "Commodite2";
    private static final String COL_Commodite3 = "Commodite3";
    private static final String COL_Commodite4 = "Commodite4";
    private static final String COL_Commodite5 = "Commodite5";
    private static final String COL_Commodite6 = "Commodite6";
    private static final String COL_Commodite7 = "Commodite7";
    private static final String COL_Commodite8 = "Commodite8";
    private static final String COL_Commodite9 = "Commodite9";
    private static final String COL_Commodite10 = "Commodite10";
    private static final String COL_Commodite11 = "Commodite11";
    private static final String COL_Commodite12 = "Commodite12";
    private static final String COL_Commodite13 = "Commodite13";
    private static final String COL_Commodite14 = "Commodite14";
    private static final String COL_Commodite15 = "Commodite15";
    private static final String COL_Commodite16 = "Commodite16";
    //private static final String COL_IdLogement = "IdLogement";
    //private static final String COL_IdCommodite = "IdCommodite";

    /***LOCALISATION*****/
    private static final String COL_Ville ="Ville";
    private static final String COL_Adresse ="Adresse";
    // private static final String COL_IdLocalisation ="IdLocalisation";

    /*****DOSSIER****/
    private static final String COL_TypeDossier ="TypeDossier";
    private static final String COL_NomDossier ="NomDossier";
    //private static final String COL_IdDossier ="IdDossier";








    private SQLiteDatabase bdd;

    private MaBaseSQLite maBaseSQLite;

    public FoldApp(Context context){
        //On crée la BDD et ses tables
        maBaseSQLite = new MaBaseSQLite(context, NOM_BDD, null, VERSION_BDD);
    }

    public void open(){
        //on ouvre la BDD en écriture
        bdd = maBaseSQLite.getWritableDatabase();
    }

    public void close(){
        //on ferme l'accès à la BDD
        bdd.close();
    }

    public SQLiteDatabase getBDD(){
        return bdd;
    }

    public long insertLogement(Logement logement){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associée à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(COL_IdLogement, logement.getIdLogement());
        values.put(COL_TypeLogement, logement.getTypeLogement());
        values.put(COL_TitreLogement, logement.getTitreLogement());
        values.put(COL_NbPiece, logement.getNbPiece());
        values.put(COL_NbChambre, logement.getNbChambre());
        values.put(COL_Surface, logement.getSurface());
        values.put(COL_Prix, logement.getPrix());
        values.put(COL_NbEtage, logement.getNbEtage());
        values.put(COL_TypeChauffage, logement.getTypeChauffage());
        values.put(COL_IdProprietaire, logement.getIdProprietaire());
        values.put(COL_IdCommodite, logement.getIdCommodite());

        //on insère l'objet dans la BDD via le ContentValues
        return bdd.insert(TableLogement, null, values);
    }

    public int updateLogement(int id, Logement logement){
        //La mise à jour d'un livre dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simplement préciser quel livre on doit mettre à jour grâce à l'ID
        ContentValues values = new ContentValues();
        values.put(COL_TypeLogement, logement.getTypeLogement());
        values.put(COL_TitreLogement, logement.getTitreLogement());
        values.put(COL_NbPiece, logement.getNbPiece());
        values.put(COL_NbChambre, logement.getNbChambre());
        values.put(COL_Surface, logement.getSurface());
        values.put(COL_Prix, logement.getPrix());
        values.put(COL_NbEtage, logement.getNbEtage());
        values.put(COL_TypeChauffage, logement.getTypeChauffage());
        values.put(COL_IdProprietaire, logement.getIdProprietaire());
        values.put(COL_IdCommodite, logement.getIdCommodite());

        return bdd.update(TableLogement, values, COL_IdLogement + " = " +id, null);
    }

    public int removeLogementWithID(int id){
        //Suppression d'un livre de la BDD grâce à l'ID
        return bdd.delete(TableLogement, COL_IdLogement + " = " +id, null);
    }

    public Logement getLogementWithTitre(String titre){
        //Récupère dans un Cursor les valeurs correspondant à un livre contenu dans la BDD (ici on sélectionne le livre grâce à son titre)
        Cursor c = bdd.query(TableLogement, new String[] {COL_IdLogement, COL_TypeLogement, COL_TitreLogement,COL_NbPiece,COL_NbChambre,COL_Surface,COL_Prix,COL_NbEtage,COL_TypeChauffage,COL_IdProprietaire,COL_IdCommodite}, COL_TitreLogement + " LIKE \"" + titre +"\"", null, null, null, null);
        return cursorToLogement(c);
    }

    //Cette méthode permet de convertir un cursor en un livre
    private Logement cursorToLogement(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        Logement logement = new Logement();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        logement.setIdLogement(c.getInt(NUM_COL_IdLogement));
        logement.setTypeLogement(c.getInt(NUM_COL_TypeLogement));
        logement.setTitreLogement(c.getString(NUM_COL_TitreLogement));
        logement.setNbPiece(c.getInt(NUM_COL_NbPiece));
        logement.setNbChambre(c.getInt(NUM_COL_NbChambre));
        logement.setSurface(c.getInt(NUM_COL_Surface));
        logement.setPrix(c.getInt(NUM_COL_Prix));
        logement.setNbEtage(c.getInt(NUM_COL_NbEtage));
        logement.setTypeChauffage(c.getInt(NUM_COL_TypeChauffage));
        logement.setNbEtage(c.getInt(NUM_COL_NbEtage));
        logement.setIdProprietaire(c.getInt(NUM_COL_IdProprietaire));
        logement.setIdCommodite(c.getInt(NUM_COL_IdCommodite));


        //On ferme le cursor
        c.close();

        //On retourne le livre
        return logement;
    }
}