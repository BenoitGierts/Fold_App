package com.foldapp.hcattiaux.foldapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Dossier> rentalProperties = new ArrayList<>();
    Context main = this;
    private int PERMISSION_GEO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_GEO);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(main);
                View mView = layoutInflaterAndroid.inflate(R.layout.content_ajout_dossier, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(main);
                alertDialogBuilderUserInput.setView(mView);

                final TextView outputTextTitre = (TextView) mView.findViewById(R.id.textView);
                final EditText userInputTitre = (EditText) mView.findViewById(R.id.editText);
                final TextView outputTextType = (TextView) mView.findViewById(R.id.textView2);
                final EditText userInputType = (EditText) mView.findViewById(R.id.editText2);

                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Valider", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                rentalProperties.add(
                                        new Dossier(userInputTitre.getText().toString(),
                                                    userInputType.getText().toString(),
                                                    "property_image_0")
                                );

                                ArrayAdapter<Dossier> adapter = new DossierArrayAdapter(main, 0, rentalProperties);

                                ListView listView = (ListView) findViewById(R.id.customListView);
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
                new Dossier("Location d'appartement","Dossier recherche d'appartement","property_image_2")
        );
        rentalProperties.add(
                new Dossier("Achat de voiture","Dossier choix voiture","car_image_1")
        );
        rentalProperties.add(
                new Dossier("Achat de maison","Dossier maison","property_image_4")
        );

        //create our new array adapter
        final ArrayAdapter<Dossier> adapter = new DossierArrayAdapter(this, 0, rentalProperties);

        //Find list view and bind it with the custom adapter
        final ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, LogementActivity.class);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long arg3) {
                AlertDialog.Builder builder = new AlertDialog.Builder(main);

                builder.setItems(new CharSequence[]
                                {"Modifier", "Supprimer","Changer l'image"},
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                switch (which) {
                                    case 0:
                                        Toast.makeText(main, "hein quoi", Toast.LENGTH_LONG);
                                        break;
                                    case 1:
                                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                                        builder.setCancelable(true);
                                        builder.setTitle("Attention");
                                        builder.setMessage("Êtes-vous sûr de vouloir supprimer le dossier selectionné ?");
                                        builder.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {
                                                rentalProperties.remove(position);
                                                findViewById(R.id.customListView);
                                                listView.setAdapter(adapter);
                                                dialog.dismiss();
                                                Toast.makeText(main, "Dossier supprimé", Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                        builder.setNegativeButton("Non", new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.cancel();
                                            }
                                        });
                                        builder.show();
                                        break;
                                    case 2:
                                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
                                        intent.setType("image/*");
                                        intent.putExtra("return-data", true);
                                        startActivityForResult(intent, which);
                                        break;
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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if(requestCode == 1 && data != null && data.getData() != null){
                    Uri _uri = data.getData();

                    if (_uri != null) {
                        //User had pick an image.
                        Cursor cursor = getContentResolver().query(_uri, new String[] { android.provider.MediaStore.Images.ImageColumns.DATA }, null, null, null);
                        cursor.moveToFirst();

                        //Link to the image
                        final String imageFilePath = cursor.getString(0);
                        Log.v("imageFilePath", imageFilePath);
                        File photos = new File(imageFilePath);
                        Bitmap b = decodeFile(photos);
                        b = Bitmap.createScaledBitmap(b,150, 150, true);
                        ImageView imageView = (ImageView) findViewById(R.id.imageLogement);
                        imageView.setImageBitmap(b);
                        cursor.close();
                    }
                }
                super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private Bitmap decodeFile(File f){
        try {
            //decode image size
            BitmapFactory.Options o = new BitmapFactory.Options();
            o.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(f),null,o);

            //Find the correct scale value. It should be the power of 2.
            final int REQUIRED_SIZE=70;
            int width_tmp=o.outWidth, height_tmp=o.outHeight;
            int scale=1;
            while(true){
                if(width_tmp/2<REQUIRED_SIZE || height_tmp/2<REQUIRED_SIZE)
                    break;
                width_tmp/=2;
                height_tmp/=2;
                scale++;
            }

            //decode with inSampleSize
            BitmapFactory.Options o2 = new BitmapFactory.Options();
            o2.inSampleSize=scale;
            return BitmapFactory.decodeStream(new FileInputStream(f), null, o2);
        } catch (FileNotFoundException e) {}
        return null;
    }

}
