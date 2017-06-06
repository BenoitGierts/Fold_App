package com.foldapp.hcattiaux.foldapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcattiaux on 22/02/17.
 */

public class LogementArrayAdapter extends ArrayAdapter {
    private Context context;
    private List<Logement> rentalProperties;

    //constructeur appelle à la creation
    public LogementArrayAdapter(Context context, int resource, ArrayList<Logement> objects) {
        super(context, resource, objects);

        this.context = context;
        this.rentalProperties = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the logement we are displaying
        Logement logement = rentalProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.location_layout, null);

        TextView description = (TextView) view.findViewById(R.id.description);
        TextView titre = (TextView) view.findViewById(R.id.titreLgmt);
        TextView nbChambre = (TextView) view.findViewById(R.id.nbChambre);
        TextView nbEtage = (TextView) view.findViewById(R.id.nbEtage);
        TextView nbPiece = (TextView) view.findViewById(R.id.nbPiece);
        TextView prix = (TextView) view.findViewById(R.id.prix);
        ImageView image = (ImageView) view.findViewById(R.id.imageLogement);

        //set address and description
        String titreLogement = logement.getTitreLogement(); // Localisation.get...  + logement.get + ", " + logement.getSuburb() + ", " + logement.getState();
        titre.setText(titreLogement);

        //display trimmed excerpt for description
        int descriptionLength = logement.getDescription().length();
        if(descriptionLength >= 100){
            String descriptionTrim = logement.getDescription().substring(0, 100) + "...";
            description.setText(descriptionTrim);
        }else{
            description.setText(logement.getDescription());
        }

        //set price and rental attributes
        prix.setText(String.valueOf(logement.getPrix()) + "€");
        nbChambre.setText("Chambre: " + String.valueOf(logement.getNbChambre()));
        nbEtage.setText("Etage: " + String.valueOf(logement.getNbEtage()));
        nbPiece.setText("Pièce: " + String.valueOf(logement.getNbPiece()));

        //get the image associated with this logement
        int imageID = context.getResources().getIdentifier(logement.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return view;
    }
}