package com.totoinc.miejemplo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.maps.MapView
import com.mapbox.maps.Style


class Mapbox : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapbox)
        val mapView: MapView = findViewById(R.id.mapView)
        mapView.getMapboxMap().loadStyleUri(Style.SATELLITE_STREETS)
    }

}