package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import com.google.gson.Gson;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JK on 8/8/2017.
 */

@Module(includes = {NetworkModule.class, GsonModule.class})
public class RetrofitModule {


    @AppScope
    @Provides
    public RxJava2CallAdapterFactory providesCallAdapter() {
        return RxJava2CallAdapterFactory.create();
    }
    @AppScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient client,
                                    Gson gson,
                                    RxJava2CallAdapterFactory rxcaf) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl("https://swapi.co/api/")
                .addCallAdapterFactory(rxcaf)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}