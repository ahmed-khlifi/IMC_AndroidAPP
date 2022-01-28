package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nom, poids, taille;
    RadioButton estFemme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.et_name);
        estFemme = (RadioButton) findViewById(R.id.rb_femme);
        poids = (EditText) findViewById(R.id.et_poid);
        taille = (EditText) findViewById(R.id.et_taille);

    }

    public void calculer(View v){


        // start new intent

        Intent i = new Intent(MainActivity.this, ResultActivity.class);
        i.putExtra("nom",nom.getText());
        i.putExtra("estFemme",estFemme.isChecked());
        i.putExtra("poids",poids.getText().toString());
        i.putExtra("taille",taille.getText().toString());

        startActivity(i);

    }
}