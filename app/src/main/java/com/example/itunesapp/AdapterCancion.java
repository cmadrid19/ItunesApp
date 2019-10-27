package com.example.itunesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.itunesapp.dto.Cancion;
import java.util.ArrayList;

public class AdapterCancion extends RecyclerView.Adapter<CancionViewHolder> {
        private ArrayList<Cancion> datos;

        public AdapterCancion (ArrayList<Cancion> canciones) {
            this.datos = canciones;
        }


        //Creo la vista, con el Holder dentro
        @Override
        public CancionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            CancionViewHolder CancionViewHolder = null;

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());

            View itemView = inflater.inflate(R.layout.layout_cancion_item, parent, false);

            CancionViewHolder = new CancionViewHolder(itemView);

            return CancionViewHolder;
        }

        //Al holder, le meto la info de cancion que toca
        @Override
        public void onBindViewHolder(CancionViewHolder holder, int position) {
            Cancion cancion = datos.get(position);
            holder.cargarCancionEnHolder(cancion);
        }

        @Override
        public int getItemCount() {
            return datos.size();
        }


    }

