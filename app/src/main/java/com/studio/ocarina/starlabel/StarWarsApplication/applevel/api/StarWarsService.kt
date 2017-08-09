package com.studio.ocarina.starlabel.StarWarsApplication.applevel.api

import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.*
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by JK on 8/8/2017.
 */
interface StarWarsService {

    @GET("people/")
    fun getAllPeople(@Query("page") page: Int): Observable<People>

    @GET("people/{id}/")
    fun getPerson(@Path("id") peopleId: Int): Observable<People>

    @GET("films/")
    fun getAllFilms(@Query("page") page: Int): Observable<Films>

    @GET("films/{id}/")
    fun getFilm(@Path("id") filmsId: Int): Observable<Films>

    @GET("starships/")
    fun getAllStarships(@Query("page") page: Int): Observable<Starships>

    @GET("starships/{id}/")
    fun getStarhip(@Path("id") starshipsId: Int): Observable<Starships>

    @GET("vehicles/")
    fun getAllVehicles(@Query("page") page: Int): Observable<Vehicles>

    @GET("vehicles/{id}/")
    fun getVehicle(@Path("id") vehiclesId: Int): Observable<Vehicles>

    @GET("planets/")
    fun getAllPlanets(@Query("page") page: Int): Observable<Planets>

    @GET("planets/{id}/")
    fun getPlanet(@Path("id") planetsId: Int): Observable<Planets>


}