package com.raul.ejerciciorestaurante;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;

import com.raul.ejerciciorestaurante.Adaptador.RecyclerViewAdapter;
import com.raul.ejerciciorestaurante.Entidad.restauranteModelo;

import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ShareActionProvider;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class misRestaurantes extends AppCompatActivity {

    private RecyclerView recyclerViewRestaurante;
    private RecyclerViewAdapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_restaurantes);

        recyclerViewRestaurante = (RecyclerView) findViewById(R.id.recyclerItem);
        recyclerViewRestaurante.setLayoutManager(new LinearLayoutManager(this));



        adaptador = new RecyclerViewAdapter(obtenerRestaurante());
        recyclerViewRestaurante.setAdapter(adaptador);
    }

    public List<restauranteModelo> obtenerRestaurante() {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "restaurante", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre, telefono, direccion, comentario;
        int valoracion = 0;

        Cursor fila = bd.rawQuery("select * from restaurante ", null);


        List<restauranteModelo> restaurantes = new ArrayList<>();

        SharedPreferences prefe = getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        String save = prefe.getString("preferencia","");

        if(save.equalsIgnoreCase("0")){
            fila = bd.rawQuery("select * from restaurante", null);
        }else if(save.equalsIgnoreCase("1")){
            fila = bd.rawQuery("select * from restaurante where valoracion= 1", null);
        }else if(save.equalsIgnoreCase("2")){
            fila = bd.rawQuery("select * from restaurante where valoracion= 2", null);
        }else if(save.equalsIgnoreCase("3")){
            fila = bd.rawQuery("select * from restaurante where valoracion= 3", null);
        }else if(save.equalsIgnoreCase("4")){
            fila = bd.rawQuery("select * from restaurante where valoracion= 4", null);
        }else if(save.equalsIgnoreCase("5")){
            fila = bd.rawQuery("select * from restaurante where valoracion= 5", null);
        }else if (save.equalsIgnoreCase("az")){
            fila = bd.rawQuery("select * from restaurante ORDER BY nombre ASC", null);
        }else if (save.equalsIgnoreCase("za")){
            fila = bd.rawQuery("select * from restaurante ORDER BY nombre DESC", null);
        }


        if (fila.moveToFirst()) {
            do{
                if (fila.getInt(4)==1) {
                    valoracion = R.drawable.valoracion_numero;
                }else if(fila.getInt(4)==2){
                    valoracion= R.drawable.valoracion_numero_dos;
                }else if(fila.getInt(4) == 3){
                    valoracion= R.drawable.valoracion_numero_tres;
                }else if (fila.getInt(4)==4){
                    valoracion= R.drawable.valoracion_numero_cuatro;
                }else if (fila.getInt(4 )==5){
                    valoracion= R.drawable.cinco_estrella_numeroc;
                }


                restaurantes.add(new restauranteModelo(valoracion,fila.getString(0),fila.getString(1),fila.getString(2),fila.getString(3)));
            }while(fila.moveToNext());



                /*nombre = (fila.getString(0));
                direccion = (fila.getString(1));
                telefono = (fila.getString(2));
                comentario = (fila.getString(3));
                valoracion = (fila.getInt(4));
*/


               // restaurantes.add(new restauranteModelo(valoracion, nombre, direccion, telefono, comentario));

        }

        return restaurantes;
    }

    public void consultaBDD(View v) {


    }
}
