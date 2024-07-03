package com.raul.ejerciciorestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class preferencias extends AppCompatActivity implements View.OnClickListener {

    ImageView fNo, fUno, fDos, fTres, fCuatro, fCinco, Baz, Bza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferencias);

        fNo = (ImageView) findViewById(R.id.filtro_no);
        fUno = (ImageView) findViewById(R.id.filtro_una);
        fDos = (ImageView) findViewById(R.id.filtro_dos);
        fTres = (ImageView) findViewById(R.id.filtro_tres);
        fCuatro = (ImageView) findViewById(R.id.filtro_cuatro);
        fCinco = (ImageView) findViewById(R.id.filtro_cinco);

        Baz = (ImageView) findViewById(R.id.orden_az);
        Bza = (ImageView) findViewById(R.id.orden_za);

        fNo.setOnClickListener(this);
        fUno.setOnClickListener(this);
        fDos.setOnClickListener(this);
        fTres.setOnClickListener(this);
        fCuatro.setOnClickListener(this);
        fCinco.setOnClickListener(this);

        Baz.setOnClickListener(this);
        Bza.setOnClickListener(this);

    }


    public void preferenciaCinco(View v) {


    }

    @Override
    public void onClick(View v) {

        int evento = v.getId();

        SharedPreferences preferencias = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();

        if (evento == R.id.filtro_no) {
            editor.putString("preferencia", "0");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro limpiado", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();

        } else if (evento == R.id.filtro_una) {
            editor.putString("preferencia", "1");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto en 1 estrella", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();

        } else if (evento == R.id.filtro_dos) {
            editor.putString("preferencia", "2");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto en 2 estrellas", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();

        } else if (evento == R.id.filtro_tres) {
            editor.putString("preferencia", "3");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto en 3 estrellas", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();

        } else if (evento == R.id.filtro_cuatro) {
            editor.putString("preferencia", "4");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto en 4 estrellas", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();

        } else if (evento == R.id.filtro_cinco) {
            editor.putString("preferencia", "5");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto en 5 estrellas", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();
        } else if (evento == R.id.orden_az) {
            editor.putString("preferencia", "az");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto por orden ascendente", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();
        } else if (evento == R.id.orden_za) {
            editor.putString("preferencia", "za");
            editor.commit();

            Toast notificacion = Toast.makeText(this, "Filtro puesto por orden descendiente", Toast.LENGTH_SHORT);
            notificacion.setGravity(Gravity.TOP, 0, 0);
            notificacion.show();
        }

    }
}
