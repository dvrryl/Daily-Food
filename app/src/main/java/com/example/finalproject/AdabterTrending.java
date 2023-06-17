package com.example.finalproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class AdabterTrending extends RecyclerView.Adapter<AdabterTrending.trendingViewHolder> {
    private List<Integer> trendingList;
    public  AdabterTrending(List<Integer> trendingList){
        this.trendingList = trendingList;
    }


    @NonNull
    @Override
    public trendingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.trending, parent,false);
        return new trendingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull trendingViewHolder holder, int position) {
        holder.imageView.setImageResource(trendingList.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ResepTrending.class);
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return trendingList.size();
    }

    public class trendingViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public trendingViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.resepTrending);
        }
    }
}

