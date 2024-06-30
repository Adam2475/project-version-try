package com.example.stableproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers
import retrofit2.http.POST

public interface MyApi {
    // Get request with localita as endpoint
    @Headers("x-apikey: cadbd43be912473b7d9b02938e88ca894d260")
    @GET("foto")
    fun getPhotos(): Call<List<MyDataItem>>
}
