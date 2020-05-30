package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ParkingInformation extends AppCompatActivity {
    TextView parkingName,textView7;
    Button idGirisYap2;
    Button idGirisYap6;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        parkingName=findViewById(R.id.parkingName);
        textView7=findViewById(R.id.textView7);
        idGirisYap2=findViewById(R.id.idGirisYap2);

        spinner=findViewById(R.id.spinner);
        Intent intent=getIntent();

        String parkingNamee= intent.getStringExtra("name");
        parkingName.setText(parkingNamee);

        String dres= intent.getStringExtra("dres");
        textView7.setText(dres);
        idGirisYap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParkingInformation.this,TheEnd.class));
            }
        });

    }

}
