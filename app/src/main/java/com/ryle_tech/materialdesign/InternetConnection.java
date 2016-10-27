package com.ryle_tech.materialdesign;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by muus on 6/29/2016.
 */
public class InternetConnection {
    Context context;

    public InternetConnection(Context context) {
        this.context = context;
    }

    public boolean isInternetAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

//        boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
