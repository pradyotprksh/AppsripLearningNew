package com.example.a3embed.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ConstantActivity extends AppCompatActivity {

    private TextView constantTextView;
    private ImageView picassoImageView;
    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constant);

        constantTextView = findViewById(R.id.constantTextView);
        picassoImageView = findViewById(R.id.picassoImageView);
        goBack = findViewById(R.id.goBack);
    }

    @Override
    protected void onStart() {
        super.onStart();
        constantTextView.setText(Constants.str + "\nset by constant file.");
        Picasso.get().load("http://upload.wikimedia.org/wikipedia/commons/e/ee/Android_green_figure" +
                ",_next_to_its_original_packaging.jpg").placeholder(R.drawable.ic_launcher_background).into(picassoImageView);

        picassoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(Constants.TAG, "ImageView Clicked");
            }
        });
        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
