/*
package com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.modules

import com.github.salomonbrys.kotson.registerTypeAdapter
import com.github.salomonbrys.kotson.value
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.dagger.annotations.AppScope
import com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models.People
import dagger.Module
import dagger.Provides


@Module
class GsonModule {

    @AppScope
    @Provides fun gson(): Gson {

        return GsonBuilder().registerTypeAdapter<People>{
            write {
                beginObject()
                value(it.birthYear)
                value(it.created)
                value(it.edited)
                value(it.url)
                value(it.name)
                value(it.gender)
                value(it.hairColor)
                value(it.eyeColor)
                value(it.skinColor)
                value(it.mass)
                value(it.height)
                value(it.homeWorld)
                beginArray()
                value(it.species)
                endArray()
                beginArray()
                value(it.pilots)
                endArray()
                beginArray()
                value(it.films)
                endArray()
                endObject()
            }
            read {
                beginObject()
                val name = nextString()
                val birthyear = nextString()
                val eye = nextString()
                val gender = nextString()
                val hair = nextString()
                val mass = nextDouble()
                val height = nextDouble()
                val skin = nextString()
                val homeworld = nextString()
                val pilots = ArrayList<String>()
                val films = ArrayList<String>()
                val species = ArrayList<String>()
                val url = nextString()
                val created = nextString()
                val edited = nextString()

                People(name, birthyear, eye, gender, hair,
                        mass, height,
                        skin, homeworld,
                        pilots, films, species,
                        url, created, edited)


            }

        }   .create()
    }

}

*/
