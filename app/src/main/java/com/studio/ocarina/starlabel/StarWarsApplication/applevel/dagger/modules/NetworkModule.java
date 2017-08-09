package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import android.content.Context;
import android.os.Build;

import com.squareup.picasso.OkHttpDownloader;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppContext;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by JK on 8/8/2017.
 */

@Module(includes = {AppModule.class, LoggerModule.class})
public class NetworkModule {
    @AppScope
    @Provides
    public File provideFile(@AppContext Context context) {
        return new File(context.getCacheDir(), "okhttp_cache");
    }

    @AppScope
    @Provides
    public Cache provideCache(File file) {
        return new Cache(file, 10 * 1000 * 1000); //10MB
    }


    @AppScope
    @Provides
    public Request providesRequest() {
        return new Request.Builder()
                .addHeader("User-Agent", "swapi-android-" + Build.VERSION.RELEASE)
                .build();
    }
    @Provides
    public OkHttpClient providesOkHttpClient(final Request request,
                                             final HttpLoggingInterceptor httpLogger,
                                             final Cache cache) {

//        final Request r = new Request.Builder()
//                .addHeader("User-Agent", "swapi-android-" + Build.VERSION.RELEASE)
//                .url("https://swapi.co/api")
//                .build();
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        return chain.proceed(request);
                    }
                })
                .addNetworkInterceptor(httpLogger)
                .cache(cache)
                .build();


    }
}