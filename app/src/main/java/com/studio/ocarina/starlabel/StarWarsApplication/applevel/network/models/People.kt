package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewTypeConstants
import paperparcel.PaperParcel
import java.util.*

//search field: name
@PaperParcel
data class People(
        @SerializedName("name")
        val name: String,

        @SerializedName("birth_year")
        val birthYear: String,

        @SerializedName("eye_color")
        val eyeColor: String,

        @SerializedName("gender")
        val gender: String,

        @SerializedName("hair_color")
        val hairColor: String,

         @SerializedName("height")
        val height: Double,

         @SerializedName("mass")
        val mass: Double,

         @SerializedName("skin_color")
        val skinColor: String,

         @SerializedName("homeworld")
        val homeWorld: String,

         @SerializedName("species")
        val species: ArrayList<String>,


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
        override fun getViewType(): Int = ViewTypeConstants.PEOPLE
        override fun writeToParcel(dest: Parcel, flags: Int) {
                PaperParcelPeople.writeToParcel(this, dest, flags)
        }

        override fun describeContents(): Int =0

        companion object {
                @JvmField val CREATOR = PaperParcelPeople.CREATOR
        }
}