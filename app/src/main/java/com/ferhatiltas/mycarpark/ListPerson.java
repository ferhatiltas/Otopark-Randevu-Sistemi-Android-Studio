package com.ferhatiltas.mycarpark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class ListPerson extends AppCompatActivity {

    List<Model> modelList=new ArrayList<>();
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton mAddBtn;
    FirebaseFirestore db;
    CustomAdapter adapter;
    ProgressDialog pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_person);

        db=FirebaseFirestore.getInstance();
        mRecyclerView=findViewById(R.id.recycler_view);
        mAddBtn=findViewById(R.id.addBtn);

        mRecyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        pd=new ProgressDialog(this);
        showData();

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListPerson.this,SignUp.class));
                finish();
            }
        });
    }
    private void showData() {
       pd.setTitle("Liste Yükleniyor...");
       pd.show();
        db.collection("Documents").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                modelList.clear();
              pd.dismiss();

              for (DocumentSnapshot doc:task.getResult()){
                  Model model=new Model(doc.getString("id"),doc.getString("ad"),doc.getString("kAd"),doc.getString("email"),
                          doc.getString("sifre"));
                  modelList.add(model);
              }
              adapter=new CustomAdapter(ListPerson.this,modelList);
              mRecyclerView.setAdapter(adapter);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(ListPerson.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    void  deleteData(int index){

        pd.setTitle("Kullanıcı Siliniyor...");
        pd.show();

        db.collection("Documents").document(modelList.get(index).getId()).delete()
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(ListPerson.this, "Silindi...", Toast.LENGTH_SHORT).show();
                        showData();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                pd.dismiss();
                Toast.makeText(ListPerson.this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
