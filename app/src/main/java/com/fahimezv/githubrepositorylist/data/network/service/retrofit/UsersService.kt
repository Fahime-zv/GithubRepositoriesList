package com.fahimezv.githubrepositorylist.data.network.service.retrofit

import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UsersService {
    @GET("users/{username}/repos")
    suspend fun repos(
        @Path("username") userName: String,
        @Query("sort") sort: String,
        @Query("type") type: String,
        @Query("page") page:Int,
        @Query("per_page") perPage:Int,
    ): List<RepoDAO>
}