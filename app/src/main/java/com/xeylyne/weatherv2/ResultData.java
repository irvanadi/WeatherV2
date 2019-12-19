package com.xeylyne.weatherv2;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coord")
    @Expose
    private ResultCoord coord;
    @SerializedName("main")
    @Expose
    private ResultTemp main;
    @SerializedName("dt")
    @Expose
    private Integer dt;
    @SerializedName("wind")
    @Expose
    private ResultWind wind;
    @SerializedName("sys")
    @Expose
    private ResultCountry sys;
    @SerializedName("rain")
    @Expose
    private Object rain;
    @SerializedName("snow")
    @Expose
    private Object snow;
    @SerializedName("clouds")
    @Expose
    private ResultsClouds clouds;
    @SerializedName("weather")
    @Expose
    private List<ResultWeather> weather = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ResultCoord getCoord() {
        return coord;
    }

    public void setCoord(ResultCoord coord) {
        this.coord = coord;
    }

    public ResultTemp getMain() {
        return main;
    }

    public void setMain(ResultTemp main) {
        this.main = main;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public ResultWind getWind() {
        return wind;
    }

    public void setWind(ResultWind wind) {
        this.wind = wind;
    }

    public ResultCountry getSys() {
        return sys;
    }

    public void setSys(ResultCountry sys) {
        this.sys = sys;
    }

    public Object getRain() {
        return rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public Object getSnow() {
        return snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public ResultsClouds getClouds() {
        return clouds;
    }

    public void setClouds(ResultsClouds clouds) {
        this.clouds = clouds;
    }

    public List<ResultWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<ResultWeather> weather) {
        this.weather = weather;
    }
}
