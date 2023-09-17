package com.example.myappgooglemarca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myappgooglemarca.Adaptador.MyInforAdapter;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnCameraIdleListener {
    private GoogleMap miMaps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMap();
    }
    public void onMapClick(@NonNull LatLng latLng) {
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        miMaps = googleMap;
        setupMapFeatures();

    }

    private void setupMapFeatures() {
        //mMap.setMapType(GoogleMap.MAP_TYPE_);
        LatLng UTEQLocation = new LatLng(-1.0109242630680952, -79.46842649490726);
        miMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(UTEQLocation, 16));
        miMaps.getUiSettings().setZoomControlsEnabled(true);


        addMapMarker(new LatLng(-1.01350399309634, -79.46815845233768), "CAFE KIMO", "Cafeteria \n Direccion: Av. Carlos J. Arosemena \n Abre: 10:30 am Cierra: 20:00 pm", R.mipmap.ic_cafeteria);
        addMapMarker(new LatLng(-1.01350399309634, -79.46815845233768), "Shake The Donut", "Cafeteria \n Direccion: Av. SHAKE THE DONUT \n Abre: 08:00 am Cierra: 10:00 pm", R.mipmap.ic_cafeteria);
        addMapMarker(new LatLng(-1.0108414790287659, -79.47047791799375), "KONITOS PIZZA", "Pizza", R.mipmap.ic_pizzeria);
        addMapMarker(new LatLng(-1.0116926846991625, -79.4668864858666), "BUNKER FRUIT", "Restaurante", R.mipmap.ic_comida);
        addMapMarker(new LatLng(-1.0116836642185463, -79.46628291962753),"Brochetas De JHOMIX","Bar-Restaurant \n Direccion: XGQM+8C9, Ciudadela las Mercedes, Quevedo \n Horario de atención de 9:30am a 5:30pm", R.mipmap.ic_bar);
        addMapMarker(new LatLng(-1.0130644337560868, -79.46684894939713),"La Facultad","Bar-Restaurant \n Direccion:XGPM+Q77, Quevedo \n Horario de atención de 2:00am a 12:00pm", R.mipmap.ic_bar);
        addMapMarker(new LatLng(-1.0116926846991625, -79.46668349447533),"Encebollado Pique y Pase","Restaurante", R.mipmap.ic_comida);
        addMapMarker(new LatLng(-1.0134964709572454, -79.46930492745352),"Lokos D' Asar","Restaurante", R.mipmap.ic_comida);
        addMapMarker(new LatLng(-1.0130228694934307, -79.4668543112106),"Toque Marinero","Restaurante\n Direccion: Av. Quito \n Abre: 07:00 am Cierra: 13:00 pm", R.mipmap.ic_comida);
        addMapMarker(new LatLng(-1.0141128250964173, -79.46832758691284),"Sweet Land - Quevedo","Heladeria", R.mipmap.ic_heladeria);
        addMapMarker(new LatLng(-1.0141242636177403, -79.46831397754428),"Las Delicias Del Olimpo","Restaurante", R.mipmap.ic_comida);
        addMapMarker(new LatLng(-1.0123224355842035, -79.46667837218212),"Carlitos' Cakes","Heladeria \n Direccion: Av. Quito y Calle Q \n Horario de atencion de 8:00am a 5:30pm;", R.mipmap.ic_heladeria);
        miMaps.setInfoWindowAdapter(new MyInforAdapter ( this));
    }

    @Override
    public void onCameraIdle() {

    }
    private void addMapMarker(LatLng pos, String titleText, String detailText, int resourceIcon) {
        MarkerOptions marker = new MarkerOptions()
                .position(pos)
                .title(titleText)
                .snippet(detailText)
                .icon(BitmapDescriptorFactory.fromResource(resourceIcon));
        miMaps.addMarker(marker);
    }
}