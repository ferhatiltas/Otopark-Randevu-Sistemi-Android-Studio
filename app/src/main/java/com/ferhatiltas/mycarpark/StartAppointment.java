package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class StartAppointment extends AppCompatActivity {
    private Button idGiris,idKayit;
    private Animation downtoup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        View idGirisYap6 = findViewById(R.id.idGirisYap6);

        downtoup= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        idGirisYap6.setAnimation(downtoup);
    }
    public void start(View view) {
        Intent intent=new Intent(getApplicationContext(),CityDistrict.class);
        startActivity(intent);
    }

}
