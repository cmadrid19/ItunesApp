package com.example.itunesapp.remote;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.itunesapp.ItunesActivity;
import com.example.itunesapp.dto.ResultadoCanciones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class QueryItunes extends AsyncTask<String, Void, ResultadoCanciones> {

    private Context context;
    private final static String URI_ITUNES = "https://itunes.apple.com/search/?media=music&term=";
    //&attribute=artistTerm albumTerm songTerm

    public QueryItunes(Context c)
    {
        this.context = c;
    }

    private URL preperarURL (String busqueda){
        URL url = null;
        String queryString = null;

        try{
            queryString = URLEncoder.encode(busqueda, "UTF-8");
            url = new URL(URI_ITUNES+queryString);
            Log.d("MIAPP", "url = "+url);
            }
            catch (Exception e)
            {
                Log.e("MIAPP", "Problemas al componer la URL", e);
            }
        return  url;
    }


    @Override//VAR ARGS
    protected ResultadoCanciones doInBackground(String... canciones) {
        ResultadoCanciones rc = null;

        URL url = null;
        HttpURLConnection httpURLConnection = null;
        InputStreamReader is = null;

        try {
            url = preperarURL(canciones[0]);//new URL(URI_ITUNES + canciones[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            String linea = null;

            Gson gson = new Gson();
            //respuesta = httpConn.getResponseCode();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                is = new InputStreamReader(httpURLConnection.getInputStream());
                rc = gson.fromJson(is, ResultadoCanciones.class);

            }


        } catch (Exception e) {
            Log.e("MIAPP", "Errro al com itunes", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                Log.e("MIAPP", "Error al liberar recursos", e);
            }
            httpURLConnection.disconnect();
        }
        return rc;
    }

    @Override
    protected void onPostExecute(ResultadoCanciones resultadoCanciones) {
        super.onPostExecute(resultadoCanciones);

        if (resultadoCanciones!=null) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(resultadoCanciones);
            System.out.println(json);
            Log.d("MIAPP", "JSON CANCIONES = " + json);
        }
        ItunesActivity ia = (ItunesActivity)this.context;
        ia.actualizarLista(resultadoCanciones);
    }
}