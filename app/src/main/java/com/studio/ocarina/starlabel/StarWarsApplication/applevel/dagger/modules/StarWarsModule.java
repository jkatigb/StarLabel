package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules;

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.api.StarWarsService;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by JK on 8/8/2017.
 */

@Module(includes = RetrofitModule.class)
public class StarWarsModule {

    @Provides
    public StarWarsService provideStarWarsService(Retrofit rf) {
        return rf.create(StarWarsService.class);
    }

}