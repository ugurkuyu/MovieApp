package com.ugurkuyu.movieapp.model.remote


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = ""
):Parcelable