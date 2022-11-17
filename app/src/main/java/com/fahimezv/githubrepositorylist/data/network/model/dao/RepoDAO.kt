package com.fahimezv.githubrepositorylist.data.network.model.dao

import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.google.gson.annotations.SerializedName

data class RepoDAO(
   @SerializedName("id")val id: Int,
   @SerializedName("name")val name: String,
   @SerializedName("url")val url: String,
   @SerializedName("owner")val owner: OwnerDAO,
) : MappableListDAO<List<Repo>> {

    override fun map(): List<Repo> {
        return listOf( Repo(id=id,name = name, url = url, owner = owner.map()))
    }

    data class OwnerDAO(
        @SerializedName("login")val login: String,
        @SerializedName("url") val url: String,
    ) : MappableDAO<Repo.Owner> {

        override fun map(): Repo.Owner {
            return Repo.Owner(login = login, url = url)
        }
    }


}
