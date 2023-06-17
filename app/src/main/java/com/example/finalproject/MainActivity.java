package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rekomendasi, trending;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rekomendasi = findViewById(R.id.recommendedRecycle);
        rekomendasi.setHasFixedSize(true);
        rekomendasi.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.a1);
        imageList.add(R.drawable.a2);
        imageList.add(R.drawable.a3);
        imageList.add(R.drawable.a4);
        imageList.add(R.drawable.a5);

        AdabterRekomendasi adabterRekomendasi = new AdabterRekomendasi(imageList);
        rekomendasi.setAdapter(adabterRekomendasi);


        trending = findViewById(R.id.trendingRecycle);
        trending.setHasFixedSize(true);
        trending.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        List<Integer> trendingList = new ArrayList<>();
        trendingList.add(R.drawable.b1);
        trendingList.add(R.drawable.b2);
        trendingList.add(R.drawable.b3);
        trendingList.add(R.drawable.b4);
        trendingList.add(R.drawable.b5);

        AdabterTrending adabterTrending = new AdabterTrending(trendingList);
        trending.setAdapter(adabterTrending);




    }
}