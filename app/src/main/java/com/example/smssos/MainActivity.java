package com.example.smssos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button_sms_sos;
    LocationManager manager;
    double latitude = 0;
    double longitude = 0;
    GPSReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_sms_sos = findViewById(R.id.button_sms_sos);

        receiver = new GPSReceiver();
        manager = (LocationManager)
                this.getSystemService(Context.LOCATION_SERVICE);

        try {
            if (ActivityCompat.checkSelfPermission(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION) !=
                    PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(this,
                            android.Manifest.permission.ACCESS_COARSE_LOCATION) !=
                            PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    1000L,
                    1.0f,
                    receiver);
        } catch (SecurityException e) {
            Toast.makeText(this,
                    "Error por permisos",
                    Toast.LENGTH_SHORT).show();
        }

        button_sms_sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SmsManager sms = SmsManager.getDefault();
                String phoneNumber = "6141234567";
                String messageBody = "Me encuentro en longitud " +
                        Double.toString(longitude) +
                        " y latitud: " +
                        Double.toString(latitude);
                try {
                    sms.sendTextMessage(phoneNumber, null,
                            messageBody, null, null);

                    Toast.makeText(MainActivity.this,
                            "Mensaje SMS SOS enviado",
                            Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    Toast.makeText(MainActivity.this,
                            "Error Mensaje no enviado",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Crear clase interna GPSReceiver
    public class GPSReceiver implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                latitude = location.getLatitude();
                longitude = location.getLongitude();
                Toast.makeText(MainActivity.this,
                        "Preparado para enviar ubicación",
                        Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,
                        "Aún sin ubicación",
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        public void onLocationChanged(@NonNull List<Location> locations) {
            LocationListener.super.onLocationChanged(locations);
        }

        @Override
        public void onFlushComplete(int requestCode) {
            LocationListener.super.onFlushComplete(requestCode);
        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {
            LocationListener.super.onProviderEnabled(provider);
            Toast.makeText(MainActivity.this,
                    "GPS habilitado",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {
            LocationListener.super.onProviderDisabled(provider);
            Toast.makeText(MainActivity.this,
                    "Favor habilitar GPS",
                    Toast.LENGTH_SHORT).show();
        }
    }
}