package com.xeylyne.weatherv2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultsClouds {

    @SerializedName("all")
    @Expose
    private Integer all;

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }
}
