package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel
import java.util.*

@PaperParcel
data class Starships(
        @SerializedName("name")
        val name: String,

        @SerializedName("model")
        val model: String,

        @SerializedName("starship_class")
        val starshipClass: String,

        @SerializedName("manufacturer")
        val manufacturer: String,

        @SerializedName("cost_in_credits")
        val cost: Double,

        @SerializedName("length")
        val length: Double,

        @SerializedName("crew")
        val crewAmountRequired: Int,

        @SerializedName("passengers")
        val passengerSize: Int,

        @SerializedName("max_atmosphering_speed")
        val maxSpeed: Double,

        @SerializedName("hyperdrive_rating")
        val hyperDriveRating: Double,

        @SerializedName("MGLT")
        val megaLightsPerHour: Double,

        @SerializedName("cargo_capacity")
        val cargoCapacityInKg: Double,

        @SerializedName("consumables")
        val consumablesCapacity: Double,

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
        override fun getViewType(): Int = ViewTypeConstants.STARSHIPS
        override fun writeToParcel(dest: Parcel, flags: Int) {
                PaperParcelStarships.writeToParcel(this, dest, flags)
        }

        override fun describeContents(): Int =0

        companion object {
                @JvmField val CREATOR = PaperParcelStarships.CREATOR
        }
}