package com.example.a3embed.learning;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class CustomActivity extends Activity {

    private static final String TAG = "CustomClass";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast.makeText(CustomActivity.this, "CustomActivity Extends Activity", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "OnCreate() method of CustomActivity is called");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart() method of CustomActivity is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume() method of CustomActivity is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause() method of CustomActivity is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop() method of CustomActivity is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy() method of CustomActivity is called");
    }

}
