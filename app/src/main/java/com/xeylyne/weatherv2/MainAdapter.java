package com.xeylyne.weatherv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    Context context;
    List<ResultTemp> resultsTemp;
    List<ResultWeather> resultsWeather;
    List<ResultCoord> resultsCoord;
    List<ResultData> resultsData;

    public MainAdapter(Context context, List<ResultTemp> resultsTemp, List<ResultWeather> resultsWeather, List<ResultCoord> resultsCoord, List<ResultData> resultsData) {
        this.context = context;
        this.resultsTemp = resultsTemp;
        this.resultsWeather = resultsWeather;
        this.resultsCoord = resultsCoord;
        this.resultsData = resultsData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ResultTemp resultTemp = resultsTemp.get(position);
        ResultWeather resultWeather = resultsWeather.get(position);
        ResultCoord resultCoord = resultsCoord.get(position);
        ResultData resultData = resultsData.get(position);
        holder.txtWeather.setText("Weather : " + resultWeather.getMain());
        holder.txtDescription.setText("Description : " + resultWeather.getDescription());
        holder.txtTempMin.setText("Temperature Min : " + resultTemp.getTempMin());
        holder.txtTempMax.setText("Temperature Max : " + resultTemp.getTempMax());
        holder.txtHumidity.setText("Humidity : " + resultTemp.getHumidity());
        holder.txtLat.setText("Latitude (Garis Lintang) : " + resultCoord.getLat());
        holder.txtLong.setText("Longitude (Garis Bujur) : " + resultCoord.getLon());
        holder.txtCountry.setText(resultData.getName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtWeather, txtDescription, txtTempMin
                , txtTempMax, txtHumidity, txtLat, txtLong, txtWindSpeed, txtCountry;

        private ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtWeather = itemView.findViewById(R.id.txtWeather);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            txtTempMin = itemView.findViewById(R.id.txtTempMin);
            txtTempMax = itemView.findViewById(R.id.txtTempMax);
            txtHumidity = itemView.findViewById(R.id.txtHumidity);
            txtWindSpeed = itemView.findViewById(R.id.txtWindSpeed);
            txtLat = itemView.findViewById(R.id.txtLat);
            txtLong = itemView.findViewById(R.id.txtLong);
            txtCountry = itemView.findViewById(R.id.txtCountry);
        }
    }
}
