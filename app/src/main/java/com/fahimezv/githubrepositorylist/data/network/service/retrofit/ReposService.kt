package com.fahimezv.githubrepositorylist.data.network.service.retrofit

import com.fahimezv.githubrepositorylist.data.network.model.dao.EventDAO
import retrofit2.http.GET
import retrofit2.http.Path

interface ReposService {
    @GET("users/repos/{username}/{repository}/events")
    suspend fun events(
        @Path("username") userName: String,
        @Path("repository") repository: String,
    ): List<EventDAO>

}