package com.studio.ocarina.starlabel.StarWarsApplication.mvp.model

import android.app.Activity
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.api.StarWarsService
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.People
import io.reactivex.Observable

class SWModel (val activity: Activity) {

    fun getCharacter(id: Int, service: StarWarsService): Observable<People>{
        val service by lazy{service.getAllPeople(id)}
        return service
    }
}