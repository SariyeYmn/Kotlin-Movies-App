package com.example.movies_app.Domain

import android.os.Parcel
import android.os.Parcelable

data class DetailDomain(val imageResourceId:Int): Parcelable{
    constructor(parcel: Parcel) : this(parcel.readInt()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResourceId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DetailDomain> {
        override fun createFromParcel(parcel: Parcel): DetailDomain {
            return DetailDomain(parcel)
        }

        override fun newArray(size: Int): Array<DetailDomain?> {
            return arrayOfNulls(size)
        }
    }

}
