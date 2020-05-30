package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import java.util.ArrayList;

public class ParkingLists extends AppCompatActivity {
    ListView lists1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);
        lists1=findViewById(R.id.lists1);

         ArrayList<String> Names=new ArrayList<>();
        Names.add(" Fırat Otopark");
        Names.add(" Harput Otopark");
        Names.add(" Gazi Otopark");
        Names.add(" Hacıoğulları Otopark");
        Names.add(" Can Otopark");
        Names.add(" Yılmazlar Otopark");

        final ArrayList<String> parkingName=new ArrayList<>();
        parkingName.add("Fırat Otopark");
        parkingName.add("Harput Otopark");
        parkingName.add("Gazi Otopark");
        parkingName.add("Hacıoğulları Otopark");
        parkingName.add("Can Otopark");
        parkingName.add("Yılmazlar Otopark");

        final ArrayList<String>  adres=new ArrayList<>();
        adres.add("Abdullah Paşa Mahallesi Kiraz Sokak Bina 27/1");
        adres.add("Akpınar Mahallesi Sanat Sokak Bina 58/1");
        adres.add("Aksaray Mahallesi Hilal Sokak Bina 89/1");
        adres.add("Ataşehir Mahallesi Şen Sokak Bina 68/1");
        adres.add("Bağlar Mahallesi İpek Sokak Bina 14/1");
        adres.add("Fevzi Çakmak Mahallesi Güler Sokak Bina 47/1");
        ArrayAdapter arrayAdapter=new ArrayAdapter(ParkingLists.this,R.layout.list_names,Names);
        lists1.setAdapter(arrayAdapter );

        lists1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {

                Intent intent=new Intent(ParkingLists.this, ParkingInformation.class);
                intent.putExtra("name",parkingName.get(i));
                intent.putExtra("dres",adres.get(i));
                startActivity(intent);
            }
        });


    }
}
