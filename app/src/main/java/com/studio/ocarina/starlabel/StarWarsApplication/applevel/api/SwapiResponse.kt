package com.studio.ocarina.starlabel.StarWarsApplication.applevel.api

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.StarWarsModelsList
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType

class SwapiResponse(val data: StarWarsModelsList<ViewType>)

