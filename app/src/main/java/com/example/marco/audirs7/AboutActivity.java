package com.example.marco.audirs7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Marco on 29.3.2016..
 */
public class AboutActivity extends AppCompatActivity {
    public ImageView btnZastupnici;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        init();
    }

    public void init() {
        btnZastupnici = (ImageView) findViewById(R.id.btnZastupnici);
        btnZastupnici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent zastupnici = new Intent(AboutActivity.this, ZastupniciActivity.class);
                Korisnik korisnik = getIntent().getExtras().getParcelable("korisnik");
                zastupnici.putExtra("korisnik", korisnik);
                startActivity(zastupnici);
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
