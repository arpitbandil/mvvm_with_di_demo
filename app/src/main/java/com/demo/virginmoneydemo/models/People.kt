package com.demo.virginmoneydemo.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class People(
    val avatar: String,
    val createdAt: String,
    val email: String,
    val favouriteColor: String,
    val firstName: String,
    val id: String,
    val jobtitle: String,
    val lastName: String,
) : Parcelable {
    val fullName: String
        get() = "$firstName $lastName"
}