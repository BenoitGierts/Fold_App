package com.foldapp.hcattiaux.foldapp.bdd;

/**
 * Created by bgierts on 10/03/17.
 */
        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class MaBaseSQLite extends SQLiteOpenHelper {
/**TABLE****/
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

    /****LOGEMENT***/
    private static final String COL_TypeLogement = "TypeLogement";
    private static final String COL_TitreLogement = "TitreLogement";
    private static final String COL_NbPiece = "NbPiece";
    private static final String COL_NbChambre = "NbChambre";
    private static final String COL_Surface = "Surface";
    private static final String COL_Prix = "Prix";
    private static final String COL_NbEtage = "NbEtage";
    private static final String COL_TypeChauffage = "TypeChauffage";
  //  private static final String COL_IdEvent ="IdLocalisation";
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






    private static final String CREATE_BDD =


            "CREATE TABLE " + TableDossier + " ("
            + COL_IdDossier + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TypeDossier + " TEXT NOT NULL, "
            + COL_NomDossier + " TEXT NOT NULL);" +

                    "CREATE TABLE " + TableLogement + " ("
            + COL_IdLogement + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_TypeLogement + " TEXT NOT NULL, "
            + COL_TitreLogement + " TEXT NOT NULL," + COL_NbPiece + " TEXT NOT NULL, "
            + COL_NbChambre + " TEXT NOT NULL, "+ COL_Surface + " TEXT NOT NULL, "
            + COL_Prix + " TEXT NOT NULL, "+ COL_NbEtage + " TEXT NOT NULL, "
            + COL_TypeChauffage + " TEXT NOT NULL," + COL_IdProprietaire + " TEXT NOT NULL, "
            + COL_IdCommodite + " TEXT NOT NULL);"  +

              "CREATE TABLE " + TableProprietaire + " ("
            + COL_IdProprietaire + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_Nom + " TEXT NOT NULL, "
            + COL_Prenom + " TEXT NOT NULL," + COL_Telephone + " TEXT NOT NULL, "
            + COL_Email + " TEXT NOT NULL, "+ COL_Sexe + " TEXT NOT NULL ," + COL_IdLogement + " TEXT NOT NULL);" +


             "CREATE TABLE " + TableEvent + " ("
            + COL_IdEvent + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_IdLogement + " TEXT NOT NULL, "
            + COL_IdDate + " TEXT NOT NULL," + COL_TypeEvent + " TEXT NOT NULL, "
            + COL_NomEvent + " TEXT NOT NULL);" +

            "CREATE TABLE " + TableDate + " ("
            + COL_IdDate + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_Heure + " TEXT NOT NULL, "
            + COL_DateJulien + " TEXT NOT NULL);" +

            "CREATE TABLE " + TableCommodite + " ("
            + COL_IdCommodite + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_IdLogement + " TEXT NOT NULL, "
            + COL_Commodite1 + " TEXT NOT NULL," + COL_Commodite2 + " TEXT NOT NULL, "
            + COL_Commodite3 + " TEXT NOT NULL, "+ COL_Commodite4 + " TEXT NOT NULL, "
            + COL_Commodite5 + " TEXT NOT NULL, "+ COL_Commodite6 + " TEXT NOT NULL, "
            + COL_Commodite7 + " TEXT NOT NULL," + COL_Commodite8 + " TEXT NOT NULL, "
            + COL_Commodite9 + " TEXT NOT NULL," + COL_Commodite10 + " TEXT NOT NULL,"
            + COL_Commodite11 + " TEXT NOT NULL," + COL_Commodite12 + " TEXT NOT NULL,"
            + COL_Commodite13 + " TEXT NOT NULL," + COL_Commodite14 + " TEXT NOT NULL,"
            + COL_Commodite15 + " TEXT NOT NULL," + COL_Commodite16 + " TEXT NOT NULL);" +

            "CREATE TABLE " + TableLocalisation + " ("
            + COL_IdLocalisation + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_Ville + " TEXT NOT NULL, "
            + COL_Adresse + " TEXT NOT NULL);"
            ;



    public MaBaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on crée la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //On peut faire ce qu'on veut ici moi j'ai décidé de supprimer la table et de la recréer
        //comme ça lorsque je change la version les id repartent de 0

        db.execSQL("DROP TABLE " + TableLogement + ";" + "DROP TABLE " + TableProprietaire + ";" + "DROP TABLE " +
                TableEvent + ";" + "DROP TABLE " + TableDate + ";" + "DROP TABLE " + TableCommodite + ";" +
                "DROP TABLE " + TableLocalisation + ";" + "DROP TABLE " + TableDossier + ";" );

        onCreate(db);
    }

}
