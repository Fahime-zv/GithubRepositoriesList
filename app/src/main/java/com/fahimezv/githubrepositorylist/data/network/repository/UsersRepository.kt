package com.fahimezv.githubrepositorylist.data.network.repository

import android.util.Log
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.data.network.service.retrofit.UsersService
import com.fahimezv.githubrepositorylist.presentation.extentions.TAG

class UsersRepository(
    private val service: UsersService,
) : BaseRepository() {
    suspend fun repos(userName: String,pageIndex:Int?): Result<List<RepoDAO>> {
        return safeApiCall {
            service.repos(userName,pageIndex)
        }
    }
}