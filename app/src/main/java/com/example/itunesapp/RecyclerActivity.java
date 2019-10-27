package com.example.itunesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.itunesapp.dto.Cancion;
import com.example.itunesapp.remote.QueryItunes;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterCancion adapterCancion;
    private ArrayList<Cancion> listaCanciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //TODO INYECTAR LOS DATOS
        //listaCanciones

        recyclerView = findViewById(R.id.RecyclerView);

        //TODO recibir la lista de canciones

        adapterCancion = new AdapterCancion(listaCanciones);

        recyclerView.setAdapter(adapterCancion);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }
}
