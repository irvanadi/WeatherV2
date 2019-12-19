package com.xeylyne.weatherv2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultCountry {

    @SerializedName("country")
    @Expose
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
