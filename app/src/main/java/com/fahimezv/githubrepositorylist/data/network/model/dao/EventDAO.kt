package com.fahimezv.githubrepositorylist.data.network.model.dao

import com.google.gson.annotations.SerializedName

data class EventDAO(
    @SerializedName("id") val id: Int,
    @SerializedName("type") val type: String,
    @SerializedName("actor") val actor: Actor,
) {
    data class Actor(
        @SerializedName("display_login") val display_login: String,
        @SerializedName("url") val url: String,

        )
}

