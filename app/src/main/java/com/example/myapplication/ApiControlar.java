package com.example.myapplication;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiControlar {

    private static final String url="https://fakestoreapi.com/";
    private static ApiControlar clientobject;

    private static Retrofit retrofit;


    ApiControlar() {

        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

    public static synchronized ApiControlar getInstance()
    {
        if(clientobject==null)
            clientobject=new ApiControlar();
        return clientobject;
    }


    ApiInterface getapi()
    {
        return retrofit.create(ApiInterface.class);
    }

}
