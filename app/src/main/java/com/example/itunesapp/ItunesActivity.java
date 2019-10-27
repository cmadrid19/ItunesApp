package com.example.itunesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.itunesapp.dto.ResultadoCanciones;
import com.example.itunesapp.remote.QueryItunes;
import com.example.itunesapp.util.InternetUtil;

public class ItunesActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void ocultarBarra ()
    {
        Log.d("MIAPP", "Ocultando");
        ProgressBar pb = findViewById(R.id.barra_progreso);
        pb.setVisibility(View.GONE);
    }

    public void actualizarLista (ResultadoCanciones rc)
    {

        ocultarBarra();
        /**
         * TODO
         *
         * 1) AÑADIR UNA CAJA DE TEXTO Y UN BOTÓN PARA LAS BÚSQUEDAS
         * 2) Llamar A LA CLASE QueryItunes CON EL TÉRMINO DE BÚSQUEDA INTRODUCIDO POR EL USUARIO
         * 3) MOSTRAR LA LISTA DE CANCIONES EN UN RECYCLER VIEW (tener en cuenta los casos de que la respuesta sea vacía o errónea)

         TAREAS OPCIONALES:

         1) TERMINAR EL ENUNCIADO DE ESTA MAÑANA DE LA NOTIFICACIÓN EN PAPARAIZZIAPP
         2) ADIVINA NUMERO APP
         3) OJEAR DOWNLOADMANAGER https://developer.android.com/reference/android/app/DownloadManager
         */


    }

    public void buscarCanciones(View view) {
        EditText editText = findViewById(R.id.editText);
        if (!editText.getText().toString().isEmpty()){
            if (InternetUtil.hayInternet(this)) {
                QueryItunes queryItunes = new QueryItunes(this);
                queryItunes.execute(editText.getText().toString());
            } else
            {
                Toast aviso = Toast.makeText(this, "NO HAY INTERNET", Toast.LENGTH_SHORT);
                aviso.show();
                ocultarBarra();
            }
        }
    }
}
