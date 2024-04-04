package com.world.quoteoftheday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Saved extends AppCompatActivity {

    RecyclerView recyclerView;
    QuoteAdapter adapter;
    List<Quote> savedQuotes;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        setContentView(R.layout.activity_saved);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sharedPreferences = getSharedPreferences("quote_details", MODE_PRIVATE);
        int quoteCounter = sharedPreferences.getInt("quote_counter", 0);


        savedQuotes = new ArrayList<>();

        for (int i = 1; i <= quoteCounter; i++) {
            String quoteText = sharedPreferences.getString("quote_" + i + "_quote_name", "");
            savedQuotes.add(new Quote(quoteText));
        }

        adapter = new QuoteAdapter(savedQuotes);
        recyclerView.setAdapter(adapter);
    }
}