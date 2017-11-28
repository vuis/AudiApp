package com.example.marco.audirs7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.marco.audirs7.Korisnik;
import com.example.marco.audirs7.R;

/**
 * Created by Marco on 5.4.2016..
 */
public class ZastupniciActivity extends AppCompatActivity {
    private TextView ime;
    private TextView nazivZastupnika1;
    private TextView podaciZastupnika1;
    private TextView nazivZastupnika2;
    private TextView podaciZastupnika2;
    private TextView nazivZastupnika3;
    private TextView podaciZastupnika3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zastupnici);
        init();


    }

    public void init() {
        Korisnik korisnik = getIntent().getExtras().getParcelable("korisnik");
        ime = (TextView) findViewById(R.id.ime);
        ime.setText(korisnik.getIme() + " " + korisnik.getPrezime() + " " + getResources().getString(R.string.odabraniGrad) + " " + "(" + korisnik.getGrad() + ")" + " " + getResources().getString(R.string.partneri));
        nazivZastupnika1 = (TextView) findViewById(R.id.nazivZastupnika1);
        podaciZastupnika1 = (TextView) findViewById(R.id.podaciZastupnika1);
        nazivZastupnika2 = (TextView) findViewById(R.id.nazivZastupnika2);
        podaciZastupnika2 = (TextView) findViewById(R.id.podaciZastupnika2);
        nazivZastupnika3 = (TextView) findViewById(R.id.nazivZastupnika3);
        podaciZastupnika3 = (TextView) findViewById(R.id.podaciZastupnika3);

        if (korisnik.getGrad().equals("Osijek")) {
            nazivZastupnika1.setText(getResources().getString(R.string.zubakOS));
            podaciZastupnika1.setText(getResources().getString(R.string.zubakOsAdresa));
            nazivZastupnika2.setText(getResources().getString(R.string.rmx));
            podaciZastupnika2.setText(getResources().getString(R.string.rmxAdresa));
        }
        if (korisnik.getGrad().equals("Zagreb")) {
            nazivZastupnika1.setText(getResources().getString(R.string.ar));
            podaciZastupnika1.setText(getResources().getString(R.string.arAdresa));
            nazivZastupnika2.setText(getResources().getString(R.string.zubakZg));
            podaciZastupnika2.setText(getResources().getString(R.string.zubakZgAdresa));
            nazivZastupnika3.setText(getResources().getString(R.string.porZg));
            podaciZastupnika3.setText(getResources().getString(R.string.porZgAdresa));

        }
        if (korisnik.getGrad().equals("Varaždin")) {
            nazivZastupnika1.setText(getResources().getString(R.string.zubakVz));
            podaciZastupnika1.setText(getResources().getString(R.string.zubakVzAdresa));
        }
        if (korisnik.getGrad().equals("Čakovec")) {
            nazivZastupnika1.setText(getResources().getString(R.string.jasen));
            podaciZastupnika1.setText(getResources().getString(R.string.jasenAdresa));
        }
        if (korisnik.getGrad().equals("Rijeka")) {
            nazivZastupnika1.setText(getResources().getString(R.string.rijeka));
            podaciZastupnika1.setText(getResources().getString(R.string.rijekaAdresa));
        }
        if (korisnik.getGrad().equals("Pula")) {
            nazivZastupnika1.setText(getResources().getString(R.string.pula));
            podaciZastupnika1.setText(getResources().getString(R.string.pulaAdresa));
        }
        if (korisnik.getGrad().equals("Zadar")) {
            nazivZastupnika1.setText(getResources().getString(R.string.ah));
            podaciZastupnika1.setText(getResources().getString(R.string.ahAdresa));
        }
        if (korisnik.getGrad().equals("Split")) {
            nazivZastupnika1.setText(getResources().getString(R.string.acSt));
            podaciZastupnika1.setText(getResources().getString(R.string.acStAdresa));
            nazivZastupnika2.setText(getResources().getString(R.string.eurodaus));
            podaciZastupnika2.setText(getResources().getString(R.string.edSt));
            nazivZastupnika3.setText(getResources().getString(R.string.porSt));
            podaciZastupnika3.setText(getResources().getString(R.string.porSttAdresa));
        }
        if (korisnik.getGrad().equals("Dubrovnik")) {
            nazivZastupnika1.setText(getResources().getString(R.string.eurodaus));
            podaciZastupnika1.setText(getResources().getString(R.string.edDu));
        }
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
