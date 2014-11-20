package com.flatironschool.forecastdb.services;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by altyus on 8/6/14.
 */
public class ForecastService {

    //TODO: Register with forecast.io and get an APIKEY

    private static final String API_URL = "https://api.forecast.io/";
    private static final String API_KEY = ENTER APIKEY HERE;

    public interface WeatherService {
        @GET("/forecast/{key}/{latitude},{longitude}")
        public void getForecastAsync(
                @Path("key") String key,
                @Path("latitude") String lat,
                @Path("longitude") String longitude,
                Callback<Forecast> callback
        );
    }

    public void loadForecastData(String lat, String lon, Callback<Forecast> callback){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        WeatherService service = restAdapter.create(WeatherService.class);
        service.getForecastAsync(API_KEY, lat, lon, callback);
    }



}
