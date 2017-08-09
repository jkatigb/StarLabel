package com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.modules

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.StarWarsAppComponent
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.StarWarsMainActivity
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.annotations.ActivityScope
import dagger.Component

@ActivityScope
@Component(modules=arrayOf(StarWarsActivityModule::class),
        dependencies = arrayOf(StarWarsAppComponent::class))
interface StarWarsActivityComponent{
    fun injectSWMainActivity(starwars: StarWarsMainActivity)
}
