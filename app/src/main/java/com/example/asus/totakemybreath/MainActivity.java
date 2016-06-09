package com.example.asus.totakemybreath;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    Button CommencezTest = (Button)findViewById(R.id.CommencezTest);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CommencezTest.setOnClickListener(new Button.OnClickListener() {

            public void onClick(View v) {

                Intent MainIntent = new Intent(MainActivity.this, DyspneeActivity.class);
                MainActivity.this.startActivity(MainIntent);

            }
        });

    }

}
