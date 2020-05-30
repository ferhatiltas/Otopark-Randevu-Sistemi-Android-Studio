package com.ferhatiltas.mycarpark;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TheEnd extends AppCompatActivity {


    Button Rkaydet,Rgeri,park1,park2,park3,park4,park5,park6,park7,park8,park9,park10,park11,park12,park13,park14,park15,park16;
   EditText rPlaka,rSaat,rRenk,rTarih;

    private String text;
    public static final String SHARED_PREFS="sharedPrefs";
    public static final String TEXT="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);

        idler();

       // showDialog();
        loadData();
    }

    public void buttonClicks(View v){
            switch (v.getId()){
                case R.id.park1:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park1.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park2:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park2.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park3:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park3.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park4:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park4.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park5:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park5.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park6:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park6.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park7:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park7.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park8:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park8.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park9:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park9.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park10:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park10.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park11:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park11.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park12:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park12.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park13:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park13.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park14:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park14.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park15:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park15.setText(rPlaka.getText().toString());

                        }
                    });
                    break;

                case R.id.park16:
                    showDialog();
                    Rkaydet.setOnClickListener(new View.OnClickListener() {

                        @Override
                        public void onClick(View v) {
                            park16.setText(rPlaka.getText().toString());

                        }
                    });
                    break;
            }
    }

    private void showDialog() {
        AlertDialog.Builder alert;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            alert=new AlertDialog.Builder(this,android.R.style.Theme_Material_Dialog_Alert);
        }
        else {
            alert=new AlertDialog.Builder(this);
        }
        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.data,null );

        rPlaka=view.findViewById(R.id.plaka);
        rRenk=view.findViewById(R.id.renk);
        rTarih=view.findViewById(R.id.Rtarih);
        rSaat=view.findViewById(R.id.Rsaat);
        Rkaydet=view.findViewById(R.id.Rkaydet);
        Rgeri=view.findViewById(R.id.Rgeri);

        alert.setView(view);
        alert.setCancelable(false);
        final AlertDialog dialog=alert.create();
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.show();

        Rkaydet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

        Rgeri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

          //      saveData();

                dialog.dismiss();
            }
        });
    }
    public void saveData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(TEXT,park1.getText().toString());

        editor.apply();
        Toast.makeText(this, "Veriler kayıt edildi.", Toast.LENGTH_SHORT).show();

    }
    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text=sharedPreferences.getString(TEXT,"");
    }
    public void updateViews(){
        park1.setText(text);
    }
    public void idler(){

        park1=findViewById(R.id.park1);
        park2=findViewById(R.id.park2);
        park3=findViewById(R.id.park3);
        park4=findViewById(R.id.park4);
        park5=findViewById(R.id.park5);
        park6=findViewById(R.id.park6);
        park7=findViewById(R.id.park7);
        park8=findViewById(R.id.park8);
        park9=findViewById(R.id.park9);
        park10=findViewById(R.id.park10);
        park11=findViewById(R.id.park11);
        park12=findViewById(R.id.park12);
        park13=findViewById(R.id.park13);
        park14=findViewById(R.id.park14);
        park15=findViewById(R.id.park15);
        park16=findViewById(R.id.park16);
        Rkaydet=findViewById(R.id.Rkaydet);
        Rgeri=findViewById(R.id.Rgeri);
        rRenk=findViewById(R.id.renk);
        rTarih=findViewById(R.id.Rtarih);
        rPlaka=findViewById(R.id.plaka);
        rSaat=findViewById(R.id.Rsaat);
    }
}