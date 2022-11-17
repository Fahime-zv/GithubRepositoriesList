package com.fahimezv.githubrepositorylist.core.entity

data class Repo(
    val id: Int,
    val name: String,
    val url: String,
    val owner: Owner,
) : NetworkReceivedModel {

    data class Owner(
        val login: String,
        val url: String,

        ) : NetworkReceivedModel
}

