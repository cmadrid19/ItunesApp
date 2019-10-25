package com.example.itunesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        if (InternetUtil.hayInternet(this)) {

            QueryItunes queryItunes = new QueryItunes(this);
            queryItunes.execute("enrique iglesias");
        } else
        {
            Toast aviso = Toast.makeText(this, "NO HAY INTERNET", Toast.LENGTH_SHORT);
            aviso.show();
        }
    }

    public void actualizarLista (ResultadoCanciones rc)
    {
        Log.d("MIAPP", "Ocultando");
        ProgressBar pb = findViewById(R.id.barra_progreso);
        pb.setVisibility(View.GONE);
    }
}
