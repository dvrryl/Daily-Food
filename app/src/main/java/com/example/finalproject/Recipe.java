package com.example.finalproject;

public class Recipe {
    private String title;
    private String imageUrl;
    private String instructions;

    public Recipe(String title, String imageUrl, String instructions) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.instructions = instructions;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getInstructions() {
        return instructions;
    }
}

