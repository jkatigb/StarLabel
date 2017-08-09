package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger;

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.StarWarsApplication;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules.AppModule;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules.GsonModule;
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules.StarWarsModule;

import dagger.Component;

/**
 * Created by JK on 8/8/2017.
 */

@AppScope
@Component(modules = {
        AppModule.class,
        GsonModule.class,
        StarWarsModule.class
})
public interface StarWarsAppComponent {
     void injectStarWarsAppComponent(StarWarsApplication starWarsApplication);
}
