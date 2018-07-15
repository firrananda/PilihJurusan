package com.example.user.proglajurusan;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Service {
    public static String BASE_URL = "http://222.124.168.221/";

    public static PostService service_post = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(PostService.class);

    public static GetService service_get = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build().create(GetService.class);

    public interface PostService{

    }

    public interface GetService{
        @GET("pakar/api/view")
        Call<TanyaModel> getTanya ();
    }
}
