package com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.modules

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.api.StarWarsService
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.StarWarsMainActivity
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.annotations.ActivityScope
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.model.SWModel
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.StarWarsPresenter
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.view.StarWarsActivityView
import dagger.Module
import dagger.Provides
import javax.inject.Inject

@ActivityScope
@Module class StarWarsActivityModule constructor(val SWActivity: StarWarsMainActivity) {

    @ActivityScope
    @Provides fun provideStarWarsMainActivity(): StarWarsMainActivity = SWActivity

    @ActivityScope
    @Provides fun provideSWMainActivityView(): StarWarsActivityView {
        return StarWarsActivityView(SWActivity)
    }
    @ActivityScope
    @Provides fun providesSWPresenter(view: StarWarsActivityView,
                                      model: SWModel): StarWarsPresenter {
        return StarWarsPresenter(view, model)
    }
    @ActivityScope
    @Provides fun providesSWModel(): SWModel {
        return SWModel(SWActivity)
    }

}


