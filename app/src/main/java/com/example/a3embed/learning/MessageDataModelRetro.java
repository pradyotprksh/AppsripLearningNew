package com.example.a3embed.learning;

import com.google.gson.annotations.SerializedName;

public class MessageDataModelRetro {

    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataModelRetro data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataModelRetro getData() {
        return data;
    }

    public void setData(DataModelRetro data) {
        this.data = data;
    }

}
