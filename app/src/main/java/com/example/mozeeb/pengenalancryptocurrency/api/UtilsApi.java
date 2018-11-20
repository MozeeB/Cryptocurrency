package com.example.mozeeb.pengenalancryptocurrency.api;

public class UtilsApi {
    public static final String BASE_URL_API= "http://20.20.20.243/cryptocurrency/";

    //mendeklarasikan Interface BaseApiService
    public static ApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(ApiService.class);
    }
}
