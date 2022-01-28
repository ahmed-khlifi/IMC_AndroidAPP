package com.example.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultat, eval;
    String poids, taille, nom;
    Boolean estFemme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        resultat = (TextView) findViewById(R.id.txt_res_cal);
        eval = (TextView) findViewById(R.id.txt_res_eval);

        poids = getIntent().getStringExtra("poids");
        taille = getIntent().getStringExtra("taille");
        estFemme = getIntent().getBooleanExtra("estFemme", true);

        showResult();
    }

    private void showResult() {
        double maPoids = Double.parseDouble(poids);
        double maTaille = Double.parseDouble(taille);
        double imc = maPoids/(maTaille+maTaille);

        resultat.setText(String.valueOf(imc));

        if (imc < 16.5 ) {
            eval.setTextColor(getResources().getColor(R.color.orange));
            eval.setText("etat de denutrition!");
        }
        else if (imc == 25 ) {
            eval.setTextColor(getResources().getColor(R.color.green));
            eval.setText("etat de normal!");
        }else{
            eval.setTextColor(getResources().getColor(R.color.red));
            eval.setText("surpoids!");
        }
    }
}