package com.example.a3embed.learning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.net.MalformedURLException;
import java.net.URL;

public class DetailsActivity extends AppCompatActivity implements Runnable {

    private View view;
    private Button downloadImage;
    private URL dowURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_details);

        view = findViewById(R.id.back_button);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DetailsActivity.this, MainActivity.class);
                startActivity(newIntent);
                finish();
            }
        });

        view = findViewById(R.id.nextImageView);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(DetailsActivity.this, NextActivity.class);
                startActivity(newIntent);
            }
        });

        try {
            dowURL = new URL(Constants.urlImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        downloadImage = findViewById(R.id.downloadImage);
        downloadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailsActivity.this, AsyncActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void run() {
        Log.d(Constants.TAG, "Thread Running");
    }

}
