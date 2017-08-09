package com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity

import android.app.Activity
import android.os.Bundle
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.StarWarsApplication
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.modules.DaggerStarWarsActivityComponent
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.activity.dagger.modules.StarWarsActivityModule
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.StarWarsPresenter
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.view.StarWarsActivityView
import javax.inject.Inject


class StarWarsMainActivity : Activity() {

    @Inject lateinit var swActivityView: StarWarsActivityView
    @Inject lateinit var presenter: StarWarsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerStarWarsActivityComponent
                        .builder()
                        .starWarsAppComponent(StarWarsApplication.get(this).SWComponent())
                        .starWarsActivityModule(StarWarsActivityModule(this))
                        .build()
                        .injectSWMainActivity(this)

        setContentView(swActivityView)
        presenter.onCreate()

        }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    }





