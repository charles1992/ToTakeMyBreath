package com.example.asus.totakemybreath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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

public class DyspneeActivity extends AppCompatActivity {

    SharedPreferences pref;
    Editor editor;
    Button envoyerButt;
    String dyspnee;
    CheckBox stade0 = (CheckBox) findViewById(R.id.Stade0);
    CheckBox stade1 = (CheckBox) findViewById(R.id.Stade1);
    CheckBox stade2 = (CheckBox) findViewById(R.id.Stade2);
    CheckBox stade3 = (CheckBox) findViewById(R.id.Stade3);
    CheckBox stade4 = (CheckBox) findViewById(R.id.Stade4);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyspnee);

        pref = getSharedPreferences("Exacerbations", 0);
        editor = pref.edit();

        envoyerButt = (Button) findViewById(R.id.Envoyer);
        envoyerButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (stade0.isChecked() || stade1.isChecked()) {

                    dyspnee = "AC";


                } else if (stade2.isChecked() || stade3.isChecked() || stade4.isChecked()) {

                    dyspnee = "BD";

                } else {

                    Toast.makeText(DyspneeActivity.this, "Vous devez sélectionner au moins une réponse", Toast.LENGTH_SHORT).show();

                }

                editor.putString("Dyspnee", dyspnee);
                editor.commit();

                Intent SendIntent = new Intent(DyspneeActivity.this, EFRActivity.class);
                DyspneeActivity.this.startActivity(SendIntent);

            }

        });

    }

}