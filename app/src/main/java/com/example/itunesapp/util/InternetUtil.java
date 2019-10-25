package com.example.itunesapp.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetUtil {

    //IMPORTANTE ANIADIR LOS PERMISOS DE RED <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    //LISTA COMPLETA DE PERMISOS https://stackoverflow.com/a/36937109/4067559 PELIGROSOS Y NO



        //metodo copiado de https://stackoverflow.com/a/34741193/4067559

        public static boolean isWifiAvailable (Context context)
        {
            boolean br = false;
            ConnectivityManager cm = null;
            NetworkInfo ni = null;

            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            ni = cm.getActiveNetworkInfo();
            br = ((null != ni) && (ni.isConnected()) && (ni.getType() == ConnectivityManager.TYPE_WIFI));

            return br;
        }


        public static boolean hayConexion3G4G (Context context)
        {
            boolean br = false;
            ConnectivityManager cm = null;
            NetworkInfo ni = null;

            cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            ni = cm.getActiveNetworkInfo();
            br = ((null != ni) && (ni.isConnected()) && (ni.getType() == ConnectivityManager.TYPE_MOBILE));

            return br;
        }

        public static boolean hayInternet(Context context) {

            boolean hay_internet = false;

            ConnectivityManager con_manager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = con_manager.getActiveNetworkInfo();

            if (ni!=null)
            {

                hay_internet = ni.isAvailable()&&ni.isConnected();
            }

            return hay_internet;

        }


}
