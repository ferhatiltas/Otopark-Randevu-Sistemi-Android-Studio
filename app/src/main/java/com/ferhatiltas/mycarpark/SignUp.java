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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SignUp extends AppCompatActivity {
    EditText idKullaniciAdi2, idKullaniciAdi3, idKullaniciAdi4, idKullaniciAdi5;
    Button idGirisYap3,mListBtn;
    TextView signUp2;
    ProgressDialog pd;
    String pId, pAd, pkAd, pEmail, pSifre;

    FirebaseAuth yetki;
    FirebaseFirestore db;
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference yol = firebaseDatabase.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        idKullaniciAdi2 = findViewById(R.id.idKullaniciAdik);
        idKullaniciAdi3 = findViewById(R.id.idKullanicjjiAdik);
        idKullaniciAdi4 = findViewById(R.id.idKullanjiciAdik);
        idKullaniciAdi5 = findViewById(R.id.idKullaniciAdıik);
        idGirisYap3 = findViewById(R.id.idGirisYsssssssap);
        signUp2 = findViewById(R.id.sigsssnUp);
        mListBtn = findViewById(R.id.listBtn);

        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();

        final Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            idGirisYap3.setText("Güncelle");
            pId = bundle.getString("pId");
            pAd = bundle.getString("pAd");
            pkAd = bundle.getString("pkAd");
            pEmail = bundle.getString("pEmail");
            pSifre = bundle.getString("pSifre");

            idKullaniciAdi2.setText(pAd);
            idKullaniciAdi3.setText(pkAd);
            idKullaniciAdi4.setText(pEmail);
            idKullaniciAdi5.setText(pSifre);
        }
        else {
            idGirisYap3.setText("Kaydet");
        }

        yetki = FirebaseAuth.getInstance();
        FirebaseApp.initializeApp(this);

        signUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUp.this, Login.class)); //Ekran değiştirme işlemini gerçekleştirir
            }
        });

        idGirisYap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(SignUp.this);
                pd.setMessage("Lütfen bekleyiniz...");
                pd.show();

                String str_kullaniciAdi = idKullaniciAdi2.getText().toString();
                String str_Ad = idKullaniciAdi3.getText().toString();
                String str_Email = idKullaniciAdi4.getText().toString();
                String str_Sifre = idKullaniciAdi5.getText().toString();


                if (TextUtils.isEmpty(str_kullaniciAdi) || TextUtils.isEmpty(str_Ad) || TextUtils.isEmpty(str_Email) || TextUtils.isEmpty(str_Sifre)) {//EditTextlerden herhangi biri boş ise uyarı versin
                    Toast.makeText(SignUp.this, "Lütfen bütün alanları doldurunuz...", Toast.LENGTH_SHORT).show();
                } else if (str_Sifre.length() < 6) {
                    Toast.makeText(SignUp.this, "Şifreniz minimum 6 karakter olmalı...", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                } else {
                    //Yeni kullanıcı  kaydetme kodlarını çağıracağız
                    uploadData(str_kullaniciAdi, str_Ad, str_Email, str_Sifre);
                }
            }
        });

        idGirisYap3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(SignUp.this);
                pd.setMessage("Lütfen bekleyiniz...");
                pd.show();
                String str_kullaniciAdi = idKullaniciAdi2.getText().toString();
                String str_Ad = idKullaniciAdi3.getText().toString();
                String str_Email = idKullaniciAdi4.getText().toString();
                String str_Sifre = idKullaniciAdi5.getText().toString();

                if (TextUtils.isEmpty(str_kullaniciAdi) || TextUtils.isEmpty(str_Ad) ||
                        TextUtils.isEmpty(str_Email) || TextUtils.isEmpty(str_Sifre)) {
                    //EditTextlerden herhangi biri boş ise uyarı versin
                    Toast.makeText(SignUp.this, "Lütfen bütün alanları doldurunuz...", Toast.LENGTH_SHORT).show();
                } else if (str_Sifre.length() < 6) {
                    Toast.makeText(SignUp.this, "Şifreniz minimum 6 karakter olmalı...", Toast.LENGTH_SHORT).show();
                    pd.dismiss();
                } else {
                    //Yeni kullanıcı  kaydetme kodlarını çağıracağız
                    uploadData(str_Ad, str_kullaniciAdi, str_Sifre, str_Email);
                    Intent intent=new Intent(SignUp.this,StartAppointment.class);
                    startActivity(intent);
                }

                Bundle bundle1 = getIntent().getExtras();
                if (bundle != null) {
                    String id = pId;
                    updateData(id, str_Ad, str_Email, str_kullaniciAdi, str_Sifre);
                } else
                    {
                    str_kullaniciAdi = idKullaniciAdi2.getText().toString().trim();
                    str_Ad = idKullaniciAdi3.getText().toString().trim();
                    str_Email = idKullaniciAdi4.getText().toString().trim();
                    str_Sifre = idKullaniciAdi5.getText().toString().trim();

                    uploadData(str_Ad, str_kullaniciAdi, str_Sifre, str_Email);
                }
            }
        });
        mListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ListPerson.class));
                finish();
            }
        });
    }

    private void updateData(String id, String str_ad, String str_email, String str_kullaniciAdi, String str_sifre) {
        pd.setTitle("Kullanıcı Güncelleniyor...");
        pd.show();
        db.collection("Documents").document(id).update("ad", str_ad,
                "kAd", str_kullaniciAdi, "email", str_email, "sifre", str_sifre)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        //Guncellem basariyla oldugunda cagrilacak
                        pd.dismiss();
                        Toast.makeText(SignUp.this, "Güncellendi...", Toast.LENGTH_SHORT).show();
                }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //Güncelleme hata verince cagirilacak
                pd.dismiss();
                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void uploadData(final String str_ad, final String str_kullaniciAdi, final String str_sifre, final String str_email) {

        pd.setTitle("Firestore Veri Ekleme");
        //          pd.show();
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("ad", str_ad);
        doc.put("kAd", str_kullaniciAdi);
        doc.put("sifre", str_sifre);
        doc.put("email", str_email);

        yetki.createUserWithEmailAndPassword(str_email,str_sifre).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    FirebaseUser firebaseKullanici = yetki.getCurrentUser();
                    String kullaniciId = firebaseKullanici.getUid();

                    yol = FirebaseDatabase.getInstance().getReference().child("Documents").child(kullaniciId);

                    HashMap<String, Object> hashMap = new HashMap<>();
                    hashMap.put("id", kullaniciId);
                    hashMap.put("kullaniciadi", str_kullaniciAdi.toLowerCase());
                    hashMap.put("ad", str_ad);
                    hashMap.put("email",str_email);
                    hashMap.put("sifre",str_sifre);

                    yol.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                pd.dismiss();
                                Intent intent = new Intent(SignUp.this, StartAppointment.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                Toast.makeText(SignUp.this, "Kayıt başarıyla gerçekleşti.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });



        FirebaseFirestore.getInstance().collection("Documents").document(id).set(doc).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                //veri başarıyla eklendiğinde bu çağrılacaktır
                pd.dismiss();
                   Toast.makeText(SignUp.this, "Kayıt Edildi...", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                //yükleme sırasında herhangi bir hata varsa bu çağrılacaktır
                pd.dismiss();
                Toast.makeText(SignUp.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

