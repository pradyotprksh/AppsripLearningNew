package com.example.a3embed.learning;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity implements ClickInterface, NewInterface {

    private ImageView backImageView;
    private Button openCustom,openConstantActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_next);

        backImageView = findViewById(R.id.backImageView);
        openCustom = findViewById(R.id.openCustom);
        openConstantActivity = findViewById(R.id.openConstantActivity);

    }

    @Override
    protected void onStart() {
        super.onStart();
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAction();
            }
        });
        openCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextActivity.this, CustomActivity.class);
                startActivity(intent);
            }
        });
        openConstantActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NextActivity.this, ConstantActivity.class);
                startActivity(intent);
                finish();
            }
        });
        getString();
    }

    @Override
    public void onClickAction() {
        finish();
    }

    @Override
    public void getString() {
        Toast.makeText(getApplicationContext(), "Another interface implementation", Toast.LENGTH_SHORT).show();
    }

}
