package com.ferhatiltas.mycarpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {
    EditText edt_email_Giris, edt_sifre_Giris;
    Button btn_giris_Yap;
    TextView txt_kayitSayfasina_Git;
    FirebaseAuth girisYetkisi;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=FirebaseFirestore.getInstance();

        edt_email_Giris=findViewById(R.id.idKullaniciAdi);
        edt_sifre_Giris=findViewById(R.id.idSifre);
        btn_giris_Yap=findViewById(R.id.idGirisYap);
        txt_kayitSayfasina_Git=findViewById(R.id.signUp);
        girisYetkisi=FirebaseAuth.getInstance();

        txt_kayitSayfasina_Git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this, SignUp.class));

            }
        });
        btn_giris_Yap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pdGiris=new ProgressDialog(Login.this);
                //Ekrana Mesaj vereceğiz
                pdGiris.setMessage("Giriş Yapılıyor...");
                pdGiris.show();

                String str_emailGiris=edt_email_Giris.getText().toString();
                String str_sifreGiris=edt_sifre_Giris.getText().toString();
                if (TextUtils.isEmpty(str_emailGiris) || TextUtils.isEmpty(str_sifreGiris)) {
                    //Boş bırakılan alan varsa ekrana uyarı verelim
                    Toast.makeText(Login.this, "Bütün Alanları Doldurunuz...", Toast.LENGTH_LONG).show();
                }
                else if (str_sifreGiris.length() < 6)
                {
                    Toast.makeText(Login.this, "Şifreniz minimum 6 karakter olmalı...", Toast.LENGTH_SHORT).show();
                    pdGiris.dismiss();
                }
                else
                    {
                    //Giriş Yapma Kodları
                    girisYetkisi.signInWithEmailAndPassword(str_emailGiris, str_sifreGiris).addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                DatabaseReference yolGiris = FirebaseDatabase.getInstance().getReference().child("Documents").child(girisYetkisi.getCurrentUser().getUid());

                                yolGiris.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        pdGiris.dismiss();//uyarıyı kapatıyorz
                                        Intent intent = new Intent(Login.this, StartAppointment.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent); //Geri dönüş olmasın
                                        finish();//Aynı yere dönmesin diye
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {
                                        pdGiris.dismiss();//İşlemi iiptal edersek uyarıyı kapatsın

                                    }
                                });
                            }
                            else {
                                pdGiris.dismiss();
                                Toast.makeText(Login.this, "Lütfen geçerli bir e-posta adresi giriniz.", Toast.LENGTH_LONG).show();
                                pdGiris.dismiss();
                            }
                        }
                    });

                }

            }
        });

    }

}
