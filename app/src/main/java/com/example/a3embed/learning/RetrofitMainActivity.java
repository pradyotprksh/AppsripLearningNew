package com.example.a3embed.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitMainActivity extends AppCompatActivity {

    private RetroEndPoints mAPIService;
    private TextView apiResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);

        mAPIService = ApiUtils.getAPIService();
        apiResponse = findViewById(R.id.apiResponse);

//        try {
//            Response<MessageDataModelRetro> response = mAPIService.savePost(1,"1","1").execute();
//            if (response.isSuccessful()) {
//                MessageDataModelRetro msgData = response.body();
//                String message = msgData.getMessage();
//                DataModelRetro data = response.body().getData();
//                String token = data.getToken();
//                String sid = data.getSid();
//                String type = data.getType();
//
//                String responseValue = "Status: " + message + "\nData:\nToken Values: " + token + "\n\nSID value: " + sid + "\n\nType Value: " + type;
//                apiResponse.setText(responseValue);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        mAPIService.savePost(112, "q", "q").enqueue(new Callback<MessageDataModelRetro>() {
            @Override
            public void onResponse(Call<MessageDataModelRetro> call, Response<MessageDataModelRetro> response) {
                if (response.isSuccessful()) {
                    MessageDataModelRetro msgData = response.body();
                    String message = msgData.getMessage();
                    DataModelRetro data = response.body().getData();
                    String token = data.getToken();
                    String sid = data.getSid();
                    String type = data.getType();

                    String responseValue = "Status: " + message + "\nData:\nToken Values: " + token + "\n\nSID value: " + sid + "\n\nType Value: " + type;
                    apiResponse.setText(responseValue);
                } else {
                    try {
                        apiResponse.setText(response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MessageDataModelRetro> call, Throwable t) {

            }
        });
    }

}
