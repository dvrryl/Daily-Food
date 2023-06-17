package com.example.finalproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdabterRekomendasi extends RecyclerView.Adapter<AdabterRekomendasi.rekomendasiViewHolder> {

    private List<Integer> rekomendasiList;

    public AdabterRekomendasi(List<Integer> rekomendasiList){
        this.rekomendasiList = rekomendasiList;
    }

    @NonNull
    @Override
    public rekomendasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rekomendasi, parent, false);
        return new rekomendasiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rekomendasiViewHolder holder, int position) {
        holder.mImageView.setImageResource(rekomendasiList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResepRekomendasi.class);
                view.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return rekomendasiList.size();
    }

    public class rekomendasiViewHolder extends RecyclerView.ViewHolder{

        private ImageView mImageView;

        public rekomendasiViewHolder(@NonNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.resepRekomendasi);
        }
    }
}
