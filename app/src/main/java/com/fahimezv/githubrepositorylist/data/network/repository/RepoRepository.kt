package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.EventDAO
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.ReposService

class RepoRepository(
    private val service: ReposService,
) : BaseRepository() {
    suspend fun events(userName: String, repoName: String): Result<List<EventDAO>> {
        return safeApiCall {
            service.events(userName, repoName)
        }
    }
}