package com.example.asus.totakemybreath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * Created by ASUS on 05/06/2016.
 */
public class ExacerbationsActivity extends AppCompatActivity {

    SharedPreferences pref3;
    SharedPreferences.Editor editor;
    CheckBox Sup2 = (CheckBox) findViewById(R.id.Sup2);
    CheckBox Inf2 = (CheckBox) findViewById(R.id.Inf2);
    Button envoyer = (Button) findViewById(R.id.Envoyer);
    String exacerbations;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exacerbations);

        pref3 = getSharedPreferences("Exacerbations", 0);
        editor = pref3.edit();

        envoyer.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                if (Sup2.isChecked()) {

                    exacerbations = "CD";


                } else if (Inf2.isChecked()) {

                    exacerbations = "AB";

                } else {

                    Toast.makeText(ExacerbationsActivity.this, "Vous devez sélectionner au moins une réponse", Toast.LENGTH_SHORT).show();

                }

                Intent ResultIntent = new Intent(ExacerbationsActivity.this, TraitementActivity.class);
                ExacerbationsActivity.this.startActivity(ResultIntent);

            }
        });

    }
}
