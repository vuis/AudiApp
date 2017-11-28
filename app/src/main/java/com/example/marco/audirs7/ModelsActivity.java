package com.example.marco.audirs7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marco on 29.3.2016..
 */
public class ModelsActivity extends AppCompatActivity {
    private List<Audi> audi;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recyclerview);

        rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        audi = new ArrayList<>();
        audi.add(new Audi("Audi A1", "Cijena: od 133.872,70 kn", "Prosječna potrošnja goriva: 5,8-3,4 l/100 km", R.drawable.a1));
        audi.add(new Audi("Audi A3", "Cijena: od 166.094,03 kn", "Prosječna potrošnja goriva: 6,6-3,4 l/100 km", R.drawable.a3));
        audi.add(new Audi("Audi A4", "Cijena: od 273.244,99 kn", "Prosječna potrošnja goriva: 7,5-4,0 l/100 km", R.drawable.a4));
        audi.add(new Audi("Audi A5", "Cijena: od 344.292,17 kn", "Prosječna potrošnja goriva: 7,5-4,2 l/100 km", R.drawable.a5));
        audi.add(new Audi("Audi A6", "Cijena: od 385.938,10 kn", "Prosječna potrošnja goriva: 7,4-4,2 l/100 km", R.drawable.a6));
        audi.add(new Audi("Audi A7", "Cijena: od 581.801,43 kn", "Prosječna potrošnja goriva: 7,6-4,7 l/100 km", R.drawable.a7));
        audi.add(new Audi("Audi A8", "Cijena: od 851.145,12 kn", "Prosječna potrošnja goriva: 8,9-5,7 l/100 km", R.drawable.a8));
        audi.add(new Audi("Audi Q2", "Ovo vozilo još nije u prodaji", "", R.drawable.q2));
        audi.add(new Audi("Audi Q3", "Cijena: od 237.199,06 kn", "Prosječna potrošnja goriva: 6,9-4,4 l/100 km", R.drawable.q3));
        audi.add(new Audi("Audi Q5", "Cijena: od 354.650,37 kn", "Prosječna potrošnja goriva: 7,5-4,9 l/100 km", R.drawable.q5));
        audi.add(new Audi("Audi Q7", "Cijena: od 588.280,22 kn", "Prosječna potrošnja goriva: 7,5-4,9 l/100 km", R.drawable.q7));
        audi.add(new Audi("Audi TT", "Cijena: od 330.004,74 kn", "Prosječna potrošnja goriva: 6,4-4,2 l/100 km", R.drawable.tt));
        audi.add(new Audi("RS modeli", "Pogledajte slike RS modela", "", R.drawable.rslogo));
    }

    private void initializeAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(audi, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if (position == 0) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a1"));
                    startActivity(browser);
                }
                if (position == 1) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a3"));
                    startActivity(browser);
                }
                if (position == 2) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a4"));
                    startActivity(browser);
                }
                if (position == 3) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a5"));
                    startActivity(browser);
                }
                if (position == 4) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a6"));
                    startActivity(browser);
                }
                if (position == 5) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a7"));
                    startActivity(browser);
                }
                if (position == 6) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/a8"));
                    startActivity(browser);
                }
                if (position == 7) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/q2"));
                    startActivity(browser);
                }
                if (position == 8) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/q3"));
                    startActivity(browser);
                }
                if (position == 9) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/q5"));
                    startActivity(browser);
                }

                if (position == 10) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/q7"));
                    startActivity(browser);
                }
                if (position == 11) {
                    Intent browser = new Intent("android.intent.action.VIEW", Uri.parse("http://www.audi.hr/tt"));
                    startActivity(browser);
                }
                if(position==12){
                    Intent rs = new Intent(getApplicationContext(), RSActivity.class);
                    startActivity(rs);
                }



            }
        });
        rv.setAdapter(adapter);
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
