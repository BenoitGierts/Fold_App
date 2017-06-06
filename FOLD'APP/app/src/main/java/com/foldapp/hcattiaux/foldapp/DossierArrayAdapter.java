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

public class DossierArrayAdapter extends ArrayAdapter {

    private Context context;
    private List<Dossier> rentalProperties;

    //constructor, call on creation
    public DossierArrayAdapter(Context context, int resource, ArrayList<Dossier> objects) {
        super(context, resource, objects);

        this.context = context;
        this.rentalProperties = objects;
    }

    //called when rendering the list
    public View getView(int position, View convertView, ViewGroup parent) {

        //get the property we are displaying
        Dossier dossier = rentalProperties.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.dossier_layout, null);

        TextView type = (TextView) view.findViewById(R.id.description);
        TextView titre = (TextView) view.findViewById(R.id.titreDossier);
        ImageView image = (ImageView) view.findViewById(R.id.imageLogement);

        type.setText(String.valueOf(dossier.getType()));
        titre.setText(String.valueOf(dossier.getTitre()));

        //get the image associated with this property
        int imageID = context.getResources().getIdentifier(dossier.getImage(), "drawable", context.getPackageName());
        image.setImageResource(imageID);

        return view;
    }

}
