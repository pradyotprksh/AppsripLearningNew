package com.example.a3embed.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IntentTransferData extends AppCompatActivity {

    private TextView dataGot;
    private String stringValueGot;
    private int intValueGot;
    private Bundle bundleValueGot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_transfer_data);

        dataGot = findViewById(R.id.dataGot);

        stringValueGot =  getIntent().getStringExtra("StringValue");
        intValueGot = getIntent().getIntExtra("IntegerValue", 5);
        bundleValueGot = getIntent().getBundleExtra("Bundle1");

        String value = ("Value Got:\n\n"
                + "String Value got: " + stringValueGot + "\n\n"
                + "Integer Value got: " + intValueGot + "\n\n"
                + "Bundle Values are: \n");

        for (String key : bundleValueGot.keySet()) {
            value = value + bundleValueGot.get(key).toString() + "\n";
        }

        dataGot.setText(value);

    }
}
