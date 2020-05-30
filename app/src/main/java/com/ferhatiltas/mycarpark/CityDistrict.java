package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class CityDistrict extends AppCompatActivity   {
    Button idGirisYap4;
    Spinner spinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tanimlar();
    }

    private void tanimlar() {
        spinner4=findViewById(R.id.spinner4);
        idGirisYap4=findViewById(R.id.idGirisYap4);
    }

    public  void listsClick(View view){
        Intent intent=new Intent(CityDistrict.this, ParkingLists.class);
        startActivity(intent);
    }

}
