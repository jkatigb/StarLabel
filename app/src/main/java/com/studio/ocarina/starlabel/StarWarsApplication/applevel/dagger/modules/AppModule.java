package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppContext;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by JK on 8/8/2017.
 */

@Module
public class AppModule {

    private final Context context;

    public AppModule(Application application){
        this.context = application.getApplicationContext();
    }
    @Provides
    @AppScope
    public Resources provideResources(@AppContext Context context) {
        return context.getResources();
    }

    @Provides
    @AppScope
    @AppContext
    public Context context() {
        return context;
    }



}
