package com.studio.ocarina.starlabel.StarWarsApplication.applevel.network.models

import android.os.Parcel
import android.os.Parcelable
import android.text.TextUtils
import com.studio.ocarina.starlabel.StarWarsApplication.mvp.presenter.adapter.ViewType
import paperparcel.PaperParcel
import java.util.*

@PaperParcel
data class StarWarsModelsList<T>(
         val count: Int,
         val next: String,
         val previous: String,
         val results: ArrayList<ViewType>
): Parcelable {

    fun hasMoreValues(): Boolean {
        return !TextUtils.isEmpty(next)
    }
    override fun writeToParcel(dest: Parcel, flags: Int) {
        PaperParcelStarWarsModelsList.writeToParcel(this, dest, flags)
    }

    override fun describeContents(): Int =0

    companion object {
        @JvmField val CREATOR = PaperParcelStarWarsModelsList.CREATOR
    }

}