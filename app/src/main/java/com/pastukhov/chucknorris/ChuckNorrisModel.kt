package com.pastukhov.chucknorris

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize


data class ChuckNorrisModel(
    val id: String,
    val value: String
)
