package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel
import java.util.*

//search fields: name
@PaperParcel
data class Planets (
        @SerializedName("name")
        val name: String,

        @SerializedName("diameter")
        val diameter: Double,

        @SerializedName("rotation_period")
        val rotationPeriod: Double,

        @SerializedName("gravity")
        val gravity: Double,

        @SerializedName("population")
        val population: Double,

        @SerializedName("climate")
        val climate: String,

        @SerializedName("terrain")
        val terrain: String,

        @SerializedName("residents")
        val residentsList: ArrayList<String>,

        @SerializedName("films")
        val films: ArrayList<String>,

        @SerializedName("pilots")
        val pilots: ArrayList<String>,

        @SerializedName("url")
        val url: String,

        @SerializedName("created")
        val created: String,

        @SerializedName("edited")
        val edited: String
) : ViewType, Parcelable {
        override fun getViewType(): Int = ViewTypeConstants.PLANETS
        override fun writeToParcel(dest: Parcel, flags: Int) {
                PaperParcelPlanets.writeToParcel(this, dest, flags)
        }

        override fun describeContents(): Int =0

        companion object {
                @JvmField val CREATOR = PaperParcelPeople.CREATOR
        }
}