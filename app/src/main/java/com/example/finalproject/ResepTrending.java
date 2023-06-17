package com.example.finalproject;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class ResepTrending extends AppCompatActivity {
    private static final String TAG = "ResepTrending";
    private static final String API_KEY = "4ca4ba3c1c1d4b9fab8cdd5b5ae4a6ac";

    private ImageView recipeImageView;
    private TextView titleTextView;
    private TextView instructionsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resep_trending);

        recipeImageView = findViewById(R.id.recipe_image);
        titleTextView = findViewById(R.id.recipe_title);
        instructionsTextView = findViewById(R.id.recipe_instructions);

        // Create OkHttpClient with logging interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        // Build the API request URL
        String url = "https://api.spoonacular.com/food/products/search?query=yogurt&apiKey=API-KEY" + API_KEY;

        // Create the request
        Request request = new Request.Builder()
                .url(url)
                .build();

        // Enqueue the request
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "API request failed", e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    Gson gson = new GsonBuilder().create();
                    String responseBody = response.body().string();

                    // Parse the JSON response using Gson
                    RecipeResponse recipeResponse = gson.fromJson(responseBody, RecipeResponse.class);

                    // Get the first recipe from the response
                    Recipe recipe = recipeResponse.getResults().get(0);

                    // Update the UI on the main thread
                    runOnUiThread(() -> {
                        displayRecipe(recipe);
                    });
                } else {
                    Log.e(TAG, "API request failed: " + response.code() + " " + response.message());
                }
            }
        });
    }

    private void displayRecipe(Recipe recipe) {
        titleTextView.setText(recipe.getTitle());
        instructionsTextView.setText(recipe.getInstructions());

        // Load the recipe image using Glide or any other image loading library
        Glide.with(this)
                .load(recipe.getImageUrl())
                .into(recipeImageView);
    }
}

