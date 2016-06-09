package com.example.asus.totakemybreath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.Toast;
import java.lang.String;

/**
 * Created by ASUS on 05/06/2016.
 */

public class EFRActivity extends AppCompatActivity {

    SharedPreferences pref2;
    SharedPreferences.Editor editor;
    EditText taille = (EditText) findViewById(R.id.Taille);
    EditText age = (EditText) findViewById(R.id.Age);
    EditText vemsExp = (EditText) findViewById(R.id.vemsexp);
    Button envoyer = (Button) findViewById(R.id.Envoyer);
    RadioButton homme = (RadioButton)findViewById(R.id.homme);
    RadioButton femme = (RadioButton)findViewById(R.id.femme);
    String efr;
    String tailleChaine = taille.getText().toString();
    String ageChaine = age.getText().toString();
    String vemsExpChaine = vemsExp.getText().toString();
    int valueTaille = Integer.parseInt(tailleChaine);
    int valueAge = Integer.parseInt(ageChaine);
    double vemsExpValue = Integer.parseInt(vemsExpChaine);
    double vemsTheo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_efr);

        // creating an shared Preference file for the information to be stored
        // first argument is the name of file and second is the mode, 0 is private mode

        pref2 = getSharedPreferences("EFR", 0);
        // get editor to edit in file
        editor = pref2.edit();

        envoyer.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                if(homme.isSelected()){

                    vemsTheo = (3.95 * valueTaille - 0.025 * valueAge - 2.6) * 1000;

                }

                else if(femme.isSelected()){

                    vemsTheo = (4.3 * valueTaille - 0.029 * valueAge - 2.49) * 1000;

                }
                else {

                    Toast.makeText(EFRActivity.this, "Vous devez remplir tous les champs", Toast.LENGTH_SHORT).show();

                }

                if(vemsExpValue/vemsTheo > 0.5) {

                    efr = "AB";

                }
                else if(vemsExpValue/vemsTheo < 0.5) {

                    efr = "CD";

                }

                Intent ExaIntent = new Intent(EFRActivity.this, ExacerbationsActivity.class);
                EFRActivity.this.startActivity(ExaIntent);

            }

        });

    }
}

