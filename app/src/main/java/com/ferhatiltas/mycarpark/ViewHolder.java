package com.ferhatiltas.mycarpark;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView mAd,mKAd,mEmail,mSifre;
    View mView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mView=itemView;
        itemView.setOnClickListener(new View.OnClickListener() {  //Kisa tiklama
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v,getAdapterPosition());

            }
        });
        itemView.setOnLongClickListener(new View.OnLongClickListener() { //Uzun tiklama
            @Override
            public boolean onLongClick(View v) {
                mClickListener.onItemLongClick(v,getAdapterPosition());

                return true;
            }
        });
        mAd=itemView.findViewById(R.id.idAd);
        mKAd=itemView.findViewById(R.id.idKAd);
        mEmail=itemView.findViewById(R.id.idEmail);
        mSifre=itemView.findViewById(R.id.idSifree);
    }
    private ViewHolder.ClickListener mClickListener;

    public  interface ClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);
    }
    public void setOnClickListener(ViewHolder.ClickListener clickListener){
        mClickListener=clickListener;
    }
}
