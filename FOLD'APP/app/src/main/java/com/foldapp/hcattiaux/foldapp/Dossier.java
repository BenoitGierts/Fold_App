package com.foldapp.hcattiaux.foldapp;

/**
 * Created by hcattiaux on 22/02/17.
 */

public class Dossier {

    private int id;
    private String type;
    private String titre;
    private String image;

    public Dossier(String type, String titre, String image) {

        this.type = type;
        this.titre = titre;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
