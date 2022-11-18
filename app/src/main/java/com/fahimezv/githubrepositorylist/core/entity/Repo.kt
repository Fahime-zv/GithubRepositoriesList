package com.fahimezv.githubrepositorylist.core.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Repo(
    val id: Int,
    val name: String,
    val url: String,
    val owner: Owner,
) : Parcelable, NetworkReceivedModel {

    @Parcelize
    data class Owner(
        val login: String,
        val url: String,
    ) : Parcelable, NetworkReceivedModel
}

