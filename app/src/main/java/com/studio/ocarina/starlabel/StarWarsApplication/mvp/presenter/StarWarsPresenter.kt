package com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter


import com.studio.ocarina.starlabel.StarWarsApplication.applevel.api.StarWarsService
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.*
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.model.SWModel
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.view.StarWarsActivityView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class StarWarsPresenter constructor(private val view: StarWarsActivityView,
                                    private val swModel: SWModel) {
    private val compositeDisposable = CompositeDisposable()

    fun onCreate() {
        compositeDisposable.add(observeSearchButton())
    }

    fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun observeSearchButton(): Disposable {
        return view.observeButton()
                .doOnNext { _ -> view.showDialog(true)
                                Timber.d("CLICKED")
                }
                .map { _ -> swModel.getCharacter(1, Service())}
                .observeOn(Schedulers.io())
                .switchMap {_ -> swModel.getCharacter(1, Service())}
                .observeOn(AndroidSchedulers.mainThread())
                .doOnEach { _ -> view.showDialog(false) }
                .retry()
                .subscribe { view.showToast("Button was clicked!") }
    }

    inner class Service: StarWarsService {
        override fun getAllPeople(page: Int): Observable<People> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getPerson(peopleId: Int): Observable<People> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAllFilms(page: Int): Observable<Films> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getFilm(filmsId: Int): Observable<Films> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAllStarships(page: Int): Observable<Starships> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getStarhip(starshipsId: Int): Observable<Starships> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAllVehicles(page: Int): Observable<Vehicles> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getVehicle(vehiclesId: Int): Observable<Vehicles> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getAllPlanets(page: Int): Observable<Planets> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun getPlanet(planetsId: Int): Observable<Planets> {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }
}
