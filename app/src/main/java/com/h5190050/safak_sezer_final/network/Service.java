package com.h5190050.safak_sezer_final.network;

import com.h5190050.safak_sezer_final.util.Constants;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Service {


    private static Retrofit retrofit;
    private static Retrofit getRetrofit() {

        if (retrofit == null) { // retrofit boşsa içeri gir
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL) //hangi linke istek atacağımı belirttim
                    .client(getOkHttpClient()) // clienti verdim
                    .addConverterFactory(GsonConverterFactory.create()) // çevirici faktörümü gson olarak verdim
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // hangi adaptörü kullanıcağımı verdim
                    .build(); // ve build ettim
        }
        return retrofit; // retrofiti return ettim
    }

    static OkHttpClient okHttpClient;
    private static OkHttpClient getOkHttpClient()
    {
        if(okHttpClient == null) { // okHttpClient boşsa içeri gir
            okHttpClient =  new OkHttpClient().newBuilder().build(); // okHttpyi build ettim
        }

        return okHttpClient; // okHttpClienti return ettim
    }

    ServiceApi serviceApi;
    public ServiceApi getServiceApi() {

        if(serviceApi == null) {//serviceApi boşsa içeri gir
            serviceApi = getRetrofit().create(ServiceApi.class); // ServiceApi.classı getRetrofit sayesinde create ettim ve serviceApiye Attım
        }

        return serviceApi; // serviceApiyi return ettim
    }
}
