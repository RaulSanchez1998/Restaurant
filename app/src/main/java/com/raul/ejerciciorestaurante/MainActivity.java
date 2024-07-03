package com.raul.ejerciciorestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void misRestaurantes(View view){
        Intent i = new Intent(this, misRestaurantes.class);
        startActivity(i);
    }

    public void anadirRestaurante(View view) {
        Intent i = new Intent(this, anadirRestaurante.class);
        startActivity(i);
    }

    public void preferencias(View view){
        Intent i = new Intent(this, preferencias.class);
        startActivity(i);
    }

    public void acercaDe(View view){
        Intent i = new Intent(this,acerca_de.class);
        startActivity(i);
    }

    public void borrar(View v){
       Intent i = new Intent(this,basurero.class);
       startActivity(i);
    }


}
