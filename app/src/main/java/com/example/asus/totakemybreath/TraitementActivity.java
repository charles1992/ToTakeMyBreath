package com.example.asus.totakemybreath;

/**
 * Created by ASUS on 05/06/2016.
 */

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TraitementActivity extends AppCompatActivity {

    TextView Traitement = (TextView) findViewById(R.id.tv_Traitement);
    SharedPreferences pref;
    SharedPreferences pref2;
    SharedPreferences pref3;
    SharedPreferences.Editor editor;
    String dyspnee = pref.getString("Dyspnee", null);
    String efr = pref2.getString("EFR", null);
    String exacerbations = pref3.getString("Exacerbations", null);
    String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traitement);

        if((dyspnee.equals("AC")) && (efr.equals("CD")) && (exacerbations.equals("AB"))) {

            result = "A";

        }
        else if((dyspnee.equals("AC")) && (efr.equals("CD")) && (exacerbations.equals("AB"))) {

            result = "C";

        }
        else if((dyspnee.equals("AC")) && (efr.equals("CD")) && (exacerbations.equals("AB"))) {

            result = "C";

        }
        else if((dyspnee.equals("BD") && (efr.equals("AB")) && (exacerbations.equals("AB")))) {

            result = "B";

        }
        else if((dyspnee.equals("BD")) && (efr.equals("AB")) && (exacerbations.equals("CD"))) {

            result = "D";

        }
        else if((dyspnee.equals("BD")) && (efr.equals("CD")) && (exacerbations.equals("AB"))) {

            result = "D";

        }

        if((result.equals("A"))) {

            Traitement.setText("A");

        }
        else if(result.equals("B")) {

            Traitement.setText("B");

        }
        else if(result.equals("C")) {

            Traitement.setText("C");

        }
        else if(result.equals("D")) {

            Traitement.setText("D");

        }
    }

}