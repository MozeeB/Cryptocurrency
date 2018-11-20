package com.example.mozeeb.pengenalancryptocurrency.api;

import com.example.mozeeb.pengenalancryptocurrency.response.ResponseCoin;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getData.php")
    Call<ResponseCoin> getAllData();
}
