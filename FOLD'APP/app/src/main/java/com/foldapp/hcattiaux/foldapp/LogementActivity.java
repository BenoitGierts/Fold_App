package com.foldapp.hcattiaux.foldapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LogementActivity extends AppCompatActivity {

    private ArrayList<Logement> rentalProperties = new ArrayList<>();
    Context logement = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logement);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(logement);
                View mView = layoutInflaterAndroid.inflate(R.layout.content_ajout_logement, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(logement);
                alertDialogBuilderUserInput.setView(mView);

                final TextView textViewTitre = (TextView) mView.findViewById(R.id.textViewTitre);
                final EditText editTextTitre = (EditText) mView.findViewById(R.id.editTextTitre);
                final TextView textViewPrix = (TextView) mView.findViewById(R.id.textViewPrix);
                final EditText editTextPrix = (EditText) mView.findViewById(R.id.editTextPrix);
                final TextView textViewDescription = (TextView) mView.findViewById(R.id.textViewDescription);
                final EditText editTextDescription = (EditText) mView.findViewById(R.id.editTextDescription);
                final TextView textViewnbChambre = (TextView) mView.findViewById(R.id.textViewnbChambre);
                final EditText editTextnbChambre = (EditText) mView.findViewById(R.id.editTextnbChambre);
                final TextView textViewnbEtage = (TextView) mView.findViewById(R.id.textViewnbEtage);
                final EditText editTextnbEtage = (EditText) mView.findViewById(R.id.editTextnbEtage);
                final TextView textViewnbPiece = (TextView) mView.findViewById(R.id.textViewnbPiece);
                final EditText editTextnbPiece = (EditText) mView.findViewById(R.id.editTextnbPiece);

                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                rentalProperties.add(
                                        new Logement(editTextTitre.getText().toString(),
                                                editTextPrix.getText().toString(),
                                                editTextDescription.getText().toString(),
                                                editTextnbChambre.getText().toString(),
                                                editTextnbEtage.getText().toString(),
                                                editTextnbPiece.getText().toString(),
                                                "property_image_0")
                                );

                                ArrayAdapter<Logement> adapter = new LogementArrayAdapter(logement, 0, rentalProperties);

                                ListView listView = (ListView) findViewById(R.id.locationListView);
                                listView.setAdapter(adapter);
                                listView.setSelection(listView.getAdapter().getCount()-1);
                            }
                        })

                        .setNegativeButton("Annuler",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });

        rentalProperties.add(
                new Logement(1,1,"Appartement 12 rue gilbert degremont","5","2",60,"650","1",1,0,1,1,1,1,
                        "Centre ville. A 100 m de la place du marché et des commerces, appartement 5 pièces entièrement rénové, sans vis-à-vis, très lumineux, exposé plein sud de 60 m².",
                        "property_image_4"));
        rentalProperties.add(
                new Logement(2,2,"Appartement 1 avenue des fleurs","3","1",49,"500","1",1,0,1,1,1,1,
                        "Métro Daumesnil. Dans immeuble Hausmannien, 2 pièces + bureau, 49 m². ",
                        "property_image_2"));

        rentalProperties.add(
                new Logement(3,3,"Appartement rue du Colisée","3","2",70,"700","1",1,0,1,1,1,1,
                        "Location vide. Disponible 6 février 2017. Métro Jasmin et église d'Auteuil. Appartement 3 pièces, traversant, 70 m², au 4ème avec ascenseur.",
                        "property_image_3"));

        //create our new array adapter
        final ArrayAdapter<Logement> adapter = new LogementArrayAdapter(this, 0, rentalProperties);

        //Find list view and bind it with the custom adapter
        final ListView listView = (ListView) findViewById(R.id.locationListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(LogementActivity.this, TabbedActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long arg3) {
                AlertDialog.Builder builder = new AlertDialog.Builder(logement);

                builder.setItems(new CharSequence[]
                                {"Modifier", "Supprimer"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        break;
                                    case 1:
                                        AlertDialog.Builder builder = new AlertDialog.Builder(LogementActivity.this);
                                        builder.setCancelable(true);
                                        builder.setTitle("Attention");
                                        builder.setMessage("Êtes-vous sûr de vouloir supprimer le logement selectionné ?");
                                        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {
                                                rentalProperties.remove(position);
                                                findViewById(R.id.customListView);
                                                listView.setAdapter(adapter);
                                                dialog.dismiss();
                                                Toast.makeText(LogementActivity.this.logement, "Logement supprimé", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        builder.show();
                                }
                            }
                        });
                builder.create().show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
