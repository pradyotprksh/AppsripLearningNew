package com.example.a3embed.learning;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DownloadImageActivity extends AppCompatActivity {

    private Bitmap bitmap;
    private ImageView bitImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        bitmap = getIntent().getParcelableExtra("image");

        bitImageView = findViewById(R.id.bitImageView);
        bitImageView.setImageBitmap(bitmap);

    }
}
