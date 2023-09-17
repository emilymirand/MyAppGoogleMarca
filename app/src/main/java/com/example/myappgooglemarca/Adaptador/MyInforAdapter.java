package com.example.myappgooglemarca.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myappgooglemarca.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

public class MyInforAdapter implements GoogleMap.InfoWindowAdapter {
    private final View mWindow;

    public MyInforAdapter(Context context) {
        mWindow = LayoutInflater.from(context).inflate(R.layout.vistamap, null);
    }
    @Override
    public View getInfoContents(@NonNull Marker marker) {
        return null;
    }

    @Nullable
    @Override
    public View getInfoWindow(@NonNull Marker marker) {
        TextView lugar = mWindow.findViewById(R.id.Nombrelugar);
        TextView direccion = mWindow.findViewById(R.id.Nombredireccion);
        lugar.setText(marker.getTitle());
        direccion.setText(marker.getSnippet());
        return mWindow;
    }
}
