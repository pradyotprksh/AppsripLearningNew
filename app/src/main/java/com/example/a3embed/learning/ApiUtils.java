package com.example.a3embed.learning;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "<<WRITE API HERE>>";

    public static RetroEndPoints getAPIService() {
        return RetrofitInstance.getClient(BASE_URL).create(RetroEndPoints.class);
    }

}
