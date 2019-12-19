package com.xeylyne.weatherv2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface APIPackage {

    @GET()
    Call<ResultMain> getAll(@Url String Url);
}
