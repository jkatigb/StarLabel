package com.studio.ocarina.starlabel.StarWarsApplication.applevel;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.google.gson.Gson;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.api.StarWarsService;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.DaggerStarWarsAppComponent;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.StarWarsAppComponent;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules.AppModule;

import javax.inject.Inject;

import timber.log.Timber;

public class StarWarsApplication extends Application {

    public static StarWarsApplication get(Activity activity) {
        return (StarWarsApplication) activity.getApplication();
    }
    public static StarWarsApplication get(Service service) {
        return (StarWarsApplication) service.getApplication();
    }

    public StarWarsAppComponent comp;
    public StarWarsAppComponent SWComponent(){
        return comp;
    }


    @Inject public Gson GSON;
    @Inject public StarWarsService SWService;


    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

        comp = DaggerStarWarsAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        comp.injectStarWarsAppComponent(this);


    }



}

