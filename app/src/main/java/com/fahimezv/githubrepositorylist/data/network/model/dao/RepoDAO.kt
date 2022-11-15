package com.fahimezv.githubrepositorylist.data.network.model.dao

import com.fahimezv.githubrepositorylist.core.entity.Repo

data class RepoDAO(
    val name: String,
    val url: String,
    val owner: OwnerDAO,
) : MappableDAO<Repo> {

    override fun map(): Repo {
        return Repo(name = name, url = url, owner = owner.map())
    }

    data class OwnerDAO(
        val login: String,
        val url: String,
    ) : MappableDAO<Repo.Owner> {

        override fun map(): Repo.Owner {
            return Repo.Owner(login = login, url = url)
        }
    }


}
