package com.xeylyne.weatherv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainAdapter mainAdapter;

    Retrofit.Builder builder = new Retrofit.Builder()
            .baseUrl("https://openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();

    APIPackage apiPackage = retrofit.create(APIPackage.class);
    List<ResultTemp> resultsTemp = new ArrayList<>();
    List<ResultWeather> resultsWeather = new ArrayList<>();
    List<ResultCoord> resultsCoord = new ArrayList<>();
    List<ResultData> resultsData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = getIntent().getStringExtra("url");

        recyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManagerVertical = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManagerVertical);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        Call<ResultMain> call = apiPackage.getAll("data/2.5/find?q="+ url +"&type=like&sort=population&cnt=1&appid=b6907d289e10d714a6e88b30761fae22&_=1576760417821");
        call.enqueue(new Callback<ResultMain>() {
            @Override
            public void onResponse(Call<ResultMain> call, Response<ResultMain> response) {
                if (response.isSuccessful()){
                    resultsData = response.body().getList();
                    resultsWeather = response.body().getList().get(0).getWeather();
                    ResultCoord resultCoord = response.body().getList().get(0).getCoord();
                    resultsCoord.add(resultCoord);
                    ResultTemp resultTemp = response.body().getList().get(0).getMain();
                    resultsTemp.add(resultTemp);

                    mainAdapter = new MainAdapter(MainActivity.this, resultsTemp, resultsWeather, resultsCoord, resultsData);
                    recyclerView.setAdapter(mainAdapter);
                    mainAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResultMain> call, Throwable t) {

            }
        });

    }
}
