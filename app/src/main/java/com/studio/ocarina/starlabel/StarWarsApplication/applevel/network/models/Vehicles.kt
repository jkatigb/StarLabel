package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel
import java.util.*

@PaperParcel
data class Vehicles(
        @SerializedName("name")
        val name: String,

        @SerializedName("model")
        val model: String,

        @SerializedName("vehicle_class")
        val vehicleClass: String,

        @SerializedName("manufacturer")
        val manufacturer: String,

        @SerializedName("length")
        val length: Double,

        @SerializedName("cost_in_credits")
        val cost: Double,

        @SerializedName("crew")
        val crewAmountRequired: Int,

        @SerializedName("passengers")
        val passengerSize: Int,

        @SerializedName("max_atmosphering_speed")
        val maxSpeed: Double,

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
        override fun getViewType(): Int = ViewTypeConstants.VEHICLES
        override fun writeToParcel(dest: Parcel, flags: Int) {
                PaperParcelVehicles.writeToParcel(this, dest, flags)
        }

        override fun describeContents(): Int =0

        companion object {
                @JvmField val CREATOR = PaperParcelVehicles.CREATOR
        }
}