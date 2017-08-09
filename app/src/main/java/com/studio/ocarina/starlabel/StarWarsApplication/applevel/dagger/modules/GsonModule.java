package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Converter;
import retrofit2.converter.gson.GsonConverterFactory;




@Module
public class GsonModule {
    @AppScope
    @Provides
    public Gson gson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }
    @AppScope
    @Provides
    public Converter.Factory provideConverter(Gson gson) {
        return GsonConverterFactory.create(gson);
    }
}
