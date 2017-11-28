package com.example.marco.audirs7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Marco on 5.4.2016..
 */
public class ChooseActivity extends AppCompatActivity {
    public ImageView btnModels;
    public ImageView btnAbout;
    public ImageView btnNews;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        init();


    }

    private void init() {
        btnModels = (ImageView) findViewById(R.id.btnModels);
        btnModels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent models = new Intent(ChooseActivity.this, ModelsActivity.class);
                startActivity(models);
            }
        });
        btnAbout = (ImageView) findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(getApplicationContext(), AboutActivity.class);
                Korisnik korisnik = getIntent().getExtras().getParcelable("korisnik");
                about.putExtra("korisnik", korisnik);
                startActivity(about);
            }
        });

        btnNews = (ImageView) findViewById(R.id.btnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/novosti/aktualno"));
                startActivity(browser);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_about:
                Intent aboutApp = new Intent(getApplicationContext(), AboutAppActivity.class);
                startActivity(aboutApp);
                return true;

            case R.id.menu_postavke:
                Intent postavke = new Intent(getApplicationContext(), PostavkeActivity.class);
                startActivity(postavke);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
