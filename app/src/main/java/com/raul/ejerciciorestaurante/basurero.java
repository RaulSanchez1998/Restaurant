package com.raul.ejerciciorestaurante;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class basurero extends AppCompatActivity {

    EditText textBorrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basurero);

        textBorrar = (EditText) findViewById(R.id.tvBorrar);
    }


    public void baja(View view) {
        String telefono = textBorrar.getText().toString();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "restaurante", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();

        if (telefono.equalsIgnoreCase("") || textBorrar.length() <= 8) {
            Toast toast1 = Toast.makeText(getApplicationContext(), "Inserte un telefono válido", Toast.LENGTH_SHORT);
            toast1.show();
        } else {
            int cant = bd.delete("restaurante", "telefono=" + telefono, null);
            bd.close();

            if (cant == 1) {
                Toast.makeText(this, "Restaurante eliminado", Toast.LENGTH_SHORT).show();
                textBorrar.setText("");
            } else
                Toast.makeText(this, "No existe el restaurante",
                        Toast.LENGTH_SHORT).show();
        }

    }

}




