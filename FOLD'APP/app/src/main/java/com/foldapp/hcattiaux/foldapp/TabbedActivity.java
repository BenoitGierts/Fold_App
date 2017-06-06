package com.foldapp.hcattiaux.foldapp;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TabbedActivity extends AppCompatActivity {

    Context tabbed = this;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private int PICK_IMAGE_REQUEST = 1;
    private static final String TAG = "TabbedActivity";
    private static final int CAMERA_REQUEST = 1888;

    int PICK_IMAGE_MULTIPLE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int position = tabLayout.getSelectedTabPosition();

                switch(position) {
                    case 0:
                        // first tab is selected
                        break;
                    case 1:
                        // second tab is selected
                        break;
                    case 2:
                        // third tab is selected
                        break;
                    case 3:

                        AlertDialog.Builder builder = new AlertDialog.Builder(tabbed);

                        builder.setItems(new CharSequence[]
                                        {"Media", "Camera"},
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        switch (which) {
                                            case 0:
                                                Intent mediaIntent = new Intent(Intent.ACTION_GET_CONTENT, null);
                                                mediaIntent.setType("image/*");
                                                mediaIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                                                mediaIntent.setAction(Intent.ACTION_GET_CONTENT);
                                                startActivityForResult(Intent.createChooser(mediaIntent, "Select Picture"), PICK_IMAGE_MULTIPLE);
                                                break;
                                            case 1:
                                                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                                                startActivityForResult(Intent.createChooser(cameraIntent, "Take Picture"), CAMERA_REQUEST);
                                                break;
                                        }
                                    }
                                });
                        builder.create().show();

                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
//
//            Uri uri = data.getData();
//            String[] projection = { MediaStore.Images.Media.DATA };
//            Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
//            cursor.moveToFirst();
//
//            Log.d(TAG, DatabaseUtils.dumpCursorToString(cursor));
//
//            int columnIndex = cursor.getColumnIndex(projection[0]);
//            String picturePath = cursor.getString(columnIndex); // returns null
//            cursor.close();
//
//            try {
//                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
////                 Log.d(TAG, String.valueOf(bitmap));
//                ImageView imageView = (ImageView) findViewById(R.id.imageView);
//                imageView.setImageBitmap(bitmap);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {

            Bitmap photo = (Bitmap) data.getExtras().get("data");
            photo = Bitmap.createScaledBitmap(photo, 300, 400, false);
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
            photo.compress(Bitmap.CompressFormat.JPEG, 40, bytes);

            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageBitmap(photo);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
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

    public static class PlaceholderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.tab1_carac, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            switch (position) {
                case 0:
                    fragment = tab1Donnees.newInstance();
                    break;
                case 1:
                    fragment= new MapFragment();
                    break;
                case 2:
                    fragment= tab3Calendrier.newInstance();
                    break;
                case 3:
                    fragment= tab4Photos.newInstance();
                    break;
                case 4:
                    fragment = tab5Autres.newInstance();
                    break;
                default:
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Données";
                case 1:
                    return "Maps";
                case 2:
                    return "Calendrier";
                case 3:
                    return "Photos";
                case 4:
                    return "Autres";
            }
            return null;
        }
    }
}
