package com.example.internetbanking.retrofit;

import android.content.Context;

import com.example.internetbanking.util.IP;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
    private static int REQUEST_TIMEOUT = 60;//change 1
    private static OkHttpClient okHttpClient;


    public static ApiService getService(Context context){
        return ApiClient.getClient(context)
                .create(ApiService.class);
    }

    public static Retrofit getClient(Context context) {

        if (okHttpClient == null)
            initOkHttp(context);

        // if (retrofit == null) {
        retrofit = new Retrofit.Builder()
                .baseUrl(IP.BASE_URL)//change 2
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // }
        return retrofit;
    }

    //----------------------------------------------------------------------

    public static ApiService getExternalApiService(Context context){
        return ApiClient.getExternalApiClient(context)
                .create(ApiService.class);
    }
    public static Retrofit getExternalApiClient(Context context) {

        if (okHttpClient == null)
            initOkHttp(context);

        //if (retrofit == null) {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://202.84.45.54:9999/bexibank/")//change 2
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //}
        return retrofit;
    }



    //----------------------------------------------------------------------


    private static void initOkHttp(final Context context) {
        OkHttpClient.Builder httpClient = new OkHttpClient().newBuilder()
                //Change
                .connectTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(REQUEST_TIMEOUT, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        httpClient.addInterceptor(interceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json");

                // Adding Authorization token (API Key)
                // Requests will be denied without API key
                //if (!TextUtils.isEmpty(PrefUtils.getApiKey(context))) {
                //requestBuilder.addHeader("Authorization", PrefUtils.getApiKey(context));
                //}

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        okHttpClient = httpClient.build();
    }


}
