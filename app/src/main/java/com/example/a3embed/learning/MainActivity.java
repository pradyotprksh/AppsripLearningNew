package com.example.a3embed.learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private Button detailsActivity, intentSendData, apiCall;
    private TextView catNoise, dogNoise, dogNoise1, dogNoise2, cowValue;
    private Thread t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate() method called");

        catNoise = findViewById(R.id.catValue);
        dogNoise = findViewById(R.id.dogValue);
        dogNoise1 = findViewById(R.id.dogValue2);
        dogNoise2 = findViewById(R.id.dogValue3);
        cowValue = findViewById(R.id.cowValue);
        apiCall = findViewById(R.id.apiCall);

        detailsActivity = findViewById(R.id.detailsActivity);

        intentSendData = findViewById(R.id.intentSendData);

        CatClass catOne = new CatClass(5, "Stuart");
        String catDetails = "Cat 1: " + catOne.makeSound();
        catNoise.setText(catDetails);

        DogClass dogOne = new DogClass(10, "Goku");
        String dogDetails = "Dog 1: " + dogOne.makeSound() + "\n" + dogOne.dogDetails();
        dogNoise.setText(dogDetails);

        DogClass dogTwo = new DogClass("Gohan");
        String dogDetails2 = "Dog 2: " + dogTwo.makeSound() + "\n" + dogTwo.dogName();
        dogNoise1.setText(dogDetails2);

        DogClass dogThree = new DogClass(3);
        String dogDetails3 = "Dog 3: " + dogThree.makeSound() + "\n" + dogThree.dogAge();
        dogNoise2.setText(dogDetails3);

        CowClass cowOne = new CowClass();
        cowOne.setAge(20);
        cowOne.setName("Goww");
        String cowDetails = "Cow 1: Cow Name: " + cowOne.getName() + " and Age: " + cowOne.getAge();
        cowValue.setText(cowDetails);

        detailsActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(newIntent);
                finish();
            }
        });

        t1 = new Thread(new DetailsActivity());
        t1.start();

        intentSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, IntentTransferData.class);
                intent.putExtra("StringValue", "MainActivity send a string value");
                intent.putExtra("IntegerValue", 20);
                Bundle bundle = new Bundle();
                bundle.putString("BundleValue1", "This is a bundle value 1");
                bundle.putString("BundleValue2", "This is a bundle value 2");
                bundle.putString("BundleValue3", "This is a bundle value 3");
                intent.putExtra("Bundle1", bundle);
                startActivity(intent);
            }
        });

        apiCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetrofitMainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() method called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() method called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() method called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() method called");
    }

}
