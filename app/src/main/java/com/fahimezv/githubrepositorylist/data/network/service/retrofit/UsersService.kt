package com.fahimezv.githubrepositorylist.data.network.service.retrofit

import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersService {
    @GET("users/{username}/repo")
    suspend fun repos(
        @Path("username") userName: String,
    ): RepoDAO
}