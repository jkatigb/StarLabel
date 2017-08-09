package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel

@PaperParcel
data class Root(
        @SerializedName("films")
        val filmsUrl: String,

        @SerializedName("people")
        val peopleUrl: String,

        @SerializedName("planets")
        val planetsUrl: String,

        @SerializedName("species")
        val speciesUrl: String,

        @SerializedName("starships")
        val starshipsUrl: String,

        @SerializedName("vehicles")
        val vehiclesUrl: String
)  : ViewType, Parcelable {
        override fun getViewType(): Int = ViewTypeConstants.ROOT
        override fun writeToParcel(dest: Parcel, flags: Int) {
                PaperParcelRoot.writeToParcel(this, dest, flags)
        }

        override fun describeContents(): Int =0

        companion object {
                @JvmField val CREATOR = PaperParcelRoot.CREATOR
        }
}