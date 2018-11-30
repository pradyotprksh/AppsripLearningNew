package com.example.a3embed.learning;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataModelRetro {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("sid")
    @Expose
    private String sid;
    @SerializedName("type")
    @Expose
    private String type;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
