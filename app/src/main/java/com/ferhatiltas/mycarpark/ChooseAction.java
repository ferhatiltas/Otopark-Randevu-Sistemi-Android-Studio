package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class ChooseAction extends AppCompatActivity {

    private Animation downtoup,slideDown;
    private Button idGiris,idKayit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_action);

        tanimlar();

    }
    public void tanimlar(){
        idGiris=findViewById(R.id.idGiris);
        idKayit=findViewById(R.id.idKayit);

        slideDown=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        idGiris.setAnimation(slideDown);

        downtoup= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        idKayit.setAnimation(downtoup);
    }

    public void chooseClicks(View v){
        switch (v.getId()){
            case R.id.idGiris:
                Intent intent=new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                break;
            case R.id.idKayit:
                Intent intentt=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intentt);
                break;
        }
    }
}
