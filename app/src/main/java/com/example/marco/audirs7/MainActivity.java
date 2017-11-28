package com.example.marco.audirs7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ImageView btnSpremi;
    private EditText imeUnos;
    private EditText prezimeUnos;
    private EditText emailUnos;
    private Korisnik korisnik;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        imeUnos = (EditText) findViewById(R.id.imeUnos);
        prezimeUnos = (EditText) findViewById(R.id.prezimeUnos);
        emailUnos = (EditText) findViewById(R.id.emailUnos);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.gradovi, R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        spinner.setAdapter(adapter);
        btnSpremi = (ImageView) findViewById(R.id.btnSpremi);
        btnSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(imeUnos.getText().toString()) || TextUtils.isEmpty(prezimeUnos.getText().toString()) || TextUtils.isEmpty(emailUnos.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Niste unijeli sve podatke", Toast.LENGTH_SHORT).show();
                    return;
                }
                korisnik = new Korisnik(imeUnos.getText().toString(), prezimeUnos.getText().toString(), emailUnos.getText().toString(),
                        spinner.getSelectedItem().toString());
                Intent object = new Intent(getApplicationContext(), ChooseActivity.class);
                object.putExtra("korisnik", korisnik);
                startActivity(object);


            }
        });


    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("korisnik", korisnik);
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