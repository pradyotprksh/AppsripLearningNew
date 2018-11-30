package com.example.a3embed.learning;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetroEndPoints {

    @Headers("language: en")
    @POST("guest/signIn")
    @FormUrlEncoded
    Call<MessageDataModelRetro> savePost(@Field("deviceType") int deviceType,
                                         @Field("deviceId") String deviceId,
                                         @Field("deviceOsVersion") String deviceOsVersion);

}
