package com.example.itunesapp;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.itunesapp.dto.Cancion;

public class CancionViewHolder extends RecyclerView.ViewHolder {

        private TextView text_view_artista;
        private TextView text_view_cancion_id;
        private TextView text_view_cancion_nombre;

        public CancionViewHolder (View itemView) {
            super(itemView);
            text_view_artista= (TextView)itemView.findViewById(R.id.LblTrackArtistName);
            text_view_cancion_id = (TextView)itemView.findViewById(R.id.LblTrackId);
            text_view_cancion_nombre = (TextView)itemView.findViewById(R.id.LblTrackName);
        }

        public void cargarCancionEnHolder(Cancion cancion) {
            text_view_artista.setText(cancion.getArtistName());
            text_view_cancion_id.setText(cancion.getTrackId());
            text_view_cancion_nombre.setText(cancion.getTrackName());
        }
    }

