package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.UsersService

class UsersRepository(
    private val service: UsersService,
) : BaseRepository() {
    suspend fun repos(userName: String, pageIndex: Int, pageSize: Int): Result<List<RepoDAO>> {
        return safeApiCall {
            service.repos(userName, "updated","all",pageIndex, pageSize)
        }
    }
}