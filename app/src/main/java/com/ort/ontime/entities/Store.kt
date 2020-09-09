package com.ort.ontime.entities

import android.os.Parcel
import android.os.Parcelable

class Store(var name: String, var description: String) : Parcelable {

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(description)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Store> = object : Parcelable.Creator<Store> {
            override fun createFromParcel(source: Parcel): Store = Store(source)
            override fun newArray(size: Int): Array<Store?> = arrayOfNulls(size)
        }
    }
}
