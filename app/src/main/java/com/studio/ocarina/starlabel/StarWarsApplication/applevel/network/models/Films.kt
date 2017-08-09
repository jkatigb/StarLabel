package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel
import java.util.*


//Search Fields: Title
@PaperParcel
data class Films (

        @SerializedName("title")
        val title: String,

        @SerializedName("episode_id")
        val episodeId : Int,

        @SerializedName("opening_crawl")
        val openingCrawl : String,

        @SerializedName("director")
        val director : String,

        @SerializedName("producer")
        val producer : String,

        @SerializedName("release_date")
        val releaseDate : String,        //TODO joda time ?

        @SerializedName("species")
        val speciesList : ArrayList<String>,

        @SerializedName("vehicles")
        val vehiclesList : ArrayList<String>,

        @SerializedName("characters")
        val charactersList : ArrayList<String>,

        @SerializedName("planets")
        val planetsList : ArrayList<String>,

        @SerializedName("url")
        val url: String,

        @SerializedName("created")
        val created: String,

        @SerializedName("edited")
        val edited: String
): ViewType, Parcelable {
    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelFilms.writeToParcel(this, dest, flags)
    }
    override fun describeContents(): Int =0

    override fun getViewType(): Int = ViewTypeConstants.FILMS

    companion object {
        @JvmField val CREATOR = PaperParcelFilms.CREATOR
    }

}