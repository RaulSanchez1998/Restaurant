package com.raul.ejerciciorestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class anadirRestaurante extends AppCompatActivity implements View.OnClickListener {
    static boolean comprobar1 = true;
    static boolean comprobar2 = true;
    static boolean comprobar3 = true;
    static boolean comprobar4 = true;
    static boolean comprobar5 = true;

    EditText etnombre, etdirec, ettelf, etcomen;
    ImageView st1, st2, st3, st4, st5;
    int valoracion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_restaurante);

        st1 = (ImageView) findViewById(R.id.imgSt1);
        st2 = (ImageView) findViewById(R.id.imgSt2);
        st3 = (ImageView) findViewById(R.id.imgSt3);
        st4 = (ImageView) findViewById(R.id.imgSt4);
        st5 = (ImageView) findViewById(R.id.imgSt5);


        etnombre = (EditText) findViewById(R.id.etNombre);
        etdirec = (EditText) findViewById(R.id.etDireccion);
        ettelf = (EditText) findViewById(R.id.etTelef);
        etcomen = (EditText) findViewById(R.id.etComent);


        etnombre.setOnClickListener(this);
        etdirec.setOnClickListener(this);
        ettelf.setOnClickListener(this);
        etcomen.setOnClickListener(this);


    }

    public void estrecion(View v) {

        int evento = v.getId();

        if (evento == R.id.imgSt1) {
            valoracion = 1;
            if (comprobar1) {
                st1.setImageResource(R.drawable.wadszxczx);
                comprobar1 = false;

            } else {
                st1.setImageResource(R.drawable.wadszxczx);
                st2.setImageResource(R.drawable.wadszxczx_vacio);
                st3.setImageResource(R.drawable.wadszxczx_vacio);
                st4.setImageResource(R.drawable.wadszxczx_vacio);
                st5.setImageResource(R.drawable.wadszxczx_vacio);
                comprobar1 = true;
                comprobar2 = true;
                comprobar3 = true;
                comprobar4 = true;
                comprobar5 = true;


            }

        }
        if (evento == R.id.imgSt2) {
            valoracion = 2;

            if (comprobar2) {
                st2.setImageResource(R.drawable.wadszxczx);

                comprobar1 = false;
                comprobar2 = false;

            } else {
                st2.setImageResource(R.drawable.wadszxczx);
                st3.setImageResource(R.drawable.wadszxczx_vacio);
                st4.setImageResource(R.drawable.wadszxczx_vacio);
                st5.setImageResource(R.drawable.wadszxczx_vacio);

                comprobar2 = true;
                comprobar3 = true;
                comprobar4 = true;
                comprobar5 = true;
            }
        }
        if (evento == R.id.imgSt3) {
            valoracion = 3;

            if (comprobar3) {
                st2.setImageResource(R.drawable.wadszxczx);
                st3.setImageResource(R.drawable.wadszxczx);
                comprobar1 = false;
                comprobar2 = false;
                comprobar3 = false;


            } else {
                st3.setImageResource(R.drawable.wadszxczx);
                st4.setImageResource(R.drawable.wadszxczx_vacio);
                st5.setImageResource(R.drawable.wadszxczx_vacio);

                comprobar3 = true;
                comprobar4 = true;
                comprobar5 = true;
            }
        }

        if (evento == R.id.imgSt4) {
            valoracion = 4;

            if (comprobar4) {
                st2.setImageResource(R.drawable.wadszxczx);
                st3.setImageResource(R.drawable.wadszxczx);
                st4.setImageResource(R.drawable.wadszxczx);
                comprobar1 = false;
                comprobar2 = false;
                comprobar3 = false;
                comprobar4 = false;

            } else {
                st4.setImageResource(R.drawable.wadszxczx);
                st5.setImageResource(R.drawable.wadszxczx_vacio);

                comprobar4 = true;
                comprobar5 = true;
            }
        }

        if (evento == R.id.imgSt5) {
            valoracion = 5;

            if (comprobar5) {
                st2.setImageResource(R.drawable.wadszxczx);
                st3.setImageResource(R.drawable.wadszxczx);
                st4.setImageResource(R.drawable.wadszxczx);
                st5.setImageResource(R.drawable.wadszxczx);
                comprobar1 = false;
                comprobar2 = false;
                comprobar3 = false;
                comprobar4 = false;
                comprobar5 = false;
            } else {
                st5.setImageResource(R.drawable.wadszxczx);


                comprobar5 = true;
            }
        }
    }

    public void cancelar(View view) {

        Toast toast1 = Toast.makeText(getApplicationContext(), "Cancelado", Toast.LENGTH_LONG);
        toast1.setGravity(Gravity.CENTER, 0, 0);
        etnombre.setText("");
        ettelf.setText("");
        etcomen.setText("");
        etdirec.setText("");
        toast1.show();
        finish();
    }


    public void alta(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "restaurante", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        String nombre = etnombre.getText().toString().toUpperCase();
        String direccion = etdirec.getText().toString();
        String telefono = ettelf.getText().toString();
        String comentario = etcomen.getText().toString();

        if (etnombre.getText().toString().equalsIgnoreCase("")) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Inserte un nombre", Toast.LENGTH_SHORT);
            toast1.show();
        } else if(etdirec.getText().toString().equalsIgnoreCase("")) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Inserte una direccion", Toast.LENGTH_SHORT);
            toast1.show();
        }else if(ettelf.getText().toString().equalsIgnoreCase("") || ettelf.length()<=8) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Inserte un telefono válido", Toast.LENGTH_SHORT);
            toast1.show();
        }else if(!etnombre.getText().toString().equalsIgnoreCase("") && !etdirec.getText().toString().equalsIgnoreCase("") && !ettelf.getText().toString().equalsIgnoreCase("") && !etcomen.getText().toString().equalsIgnoreCase("") ){
            ContentValues registro = new ContentValues();
            registro.put("valoracion", valoracion);
            registro.put("nombre", nombre);
            registro.put("direccion", direccion);
            registro.put("telefono", telefono);
            registro.put("comentarios", comentario);


            // los inserto en la base de datos
           /* bd.insert("restaurante", null, registro);
            bd.close();*/
            long cant =  bd.insert("restaurante", null, registro);;
            bd.close();

            if (cant == 1) {

                Toast.makeText(this, "Introducido con exito",
                        Toast.LENGTH_SHORT).show();

            } else{
                Toast.makeText(this, "Ya hay un restaurante con ese numero, ponga otro", Toast.LENGTH_SHORT).show();
                etnombre.setText("");
                ettelf.setText("");
                etcomen.setText("");
                etdirec.setText("");

            }

            // ponemos los campos a vacío para insertar el siguiente usuario


        }
    }

    @Override
    public void onClick(View v) {
        int evento = v.getId();


        if (evento == R.id.etNombre) {
            v.setFocusable(true);
            v.setFocusableInTouchMode(true);
        } else if (evento == R.id.etDireccion) {
            v.setFocusableInTouchMode(true);
            v.setFocusable(true);
        } else if (evento == R.id.etTelef) {
            v.setFocusableInTouchMode(true);
            v.setFocusable(true);
        } else if (evento == R.id.etComent) {
            v.setFocusableInTouchMode(true);
            v.setFocusable(true);
        }


    }
}

