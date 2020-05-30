package com.ferhatiltas.mycarpark;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    ListPerson listActivity;
    List<Model> modelList;
   Context context;

    public CustomAdapter(ListPerson listActivity, List<Model> modelList) {
        this.listActivity = listActivity;
        this.modelList = modelList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int i) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_layo,parent,false);
       ViewHolder viewHolder=new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Kullanici ogeye tikladiğinda bu metot cagirilacak

                //Tiklama aninda verileri toast mesaji olarak goster
                String isim=modelList.get(position).getAd();
                String kKsim=modelList.get(position).getkAd();
                String gmail=modelList.get(position).getEmail();
                String password=modelList.get(position).getSifre();
                Toast.makeText(listActivity, isim+"\n"+kKsim+"\n"+gmail+"\n"+password, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, final int position) {
                //Kullanici ogeye  uzun tikladiğinda bu metot cagirilacak

                AlertDialog.Builder builder=new AlertDialog.Builder(listActivity);
                String[] options={"Bilgileri Güncelle", "Bilgileri Sil"};
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (which == 0) {
                            //Guncelleye tiklarsa
                            String id=modelList.get(position).getId();
                            String ad=modelList.get(position).getAd();
                            String kAd=modelList.get(position).getkAd();
                            String email=modelList.get(position).getEmail();
                            String sifre=modelList.get(position).getSifre();

                            Intent intent=new Intent(listActivity,SignUp.class);

                            intent.putExtra("pId",id);
                            intent.putExtra("pAd",ad);
                            intent.putExtra("pkAd",kAd);
                            intent.putExtra("pEmail",email);
                            intent.putExtra("pSifre",sifre);

                            listActivity.startActivity(intent);
                        }
                        if (which == 1) {
                            //Sile tiklarsa
                            listActivity.deleteData(position);
                        }

                    }
                }).create().show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            //Gorunum verilerini baglama
        viewHolder.mAd.setText(modelList.get(i).getAd());
        viewHolder.mKAd.setText(modelList.get(i).getkAd());
        viewHolder.mEmail.setText(modelList.get(i).getEmail());
        viewHolder.mSifre.setText(modelList.get(i).getSifre());
    }
    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
