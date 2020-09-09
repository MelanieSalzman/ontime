package com.ort.ontime.entities

import android.os.Parcel
import android.os.Parcelable

class User(var name: String, var email: String, var password: String) : Parcelable {

    constructor(source: Parcel) : this(
        source.readString()!!,
        source.readString()!!,
        source.readString()!!
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(email)
        writeString(password)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}