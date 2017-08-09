package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by JK on 8/8/2017.
 */


@Module
public class LoggerModule {
    @AppScope
    @Provides
    public HttpLoggingInterceptor provideHttpInterceptor(HttpLoggingInterceptor.Logger logger) {
        return new HttpLoggingInterceptor(logger)
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
    @AppScope
    @Provides
    public HttpLoggingInterceptor.Logger provideHttpLogger(){
        return new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.d(message);
            }
        };
    }


}