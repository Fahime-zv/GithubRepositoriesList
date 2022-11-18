package com.fahimezv.githubrepositorylist.core.entity


data class Event(
    val id: Long,
    val type: String,
    val actor: Actor,
) : NetworkReceivedModel {
    data class Actor(
        val display_login: String,
        val url: String,

        ) : NetworkReceivedModel
}
