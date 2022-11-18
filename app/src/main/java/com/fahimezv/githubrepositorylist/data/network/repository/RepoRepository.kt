package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.core.entity.Event
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.ReposService

class RepoRepository(
    private val service: ReposService,
) : BaseRepository() {

    suspend fun events(userName: String, repoName: String): Result<List<Event>> {
        return safeApiCall {
            service.events(userName, repoName).map { it.map() }
        }
    }

}