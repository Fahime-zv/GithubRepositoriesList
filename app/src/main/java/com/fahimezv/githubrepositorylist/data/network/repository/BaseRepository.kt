package com.fahimezv.githubrepositorylist.data.network.repository

import android.util.Log
import com.fahimezv.githubrepositorylist.core.entity.NetworkReceivedModel
import com.fahimezv.githubrepositorylist.data.network.model.dao.MappableDAO
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.presentation.extentions.TAG

abstract class BaseRepository {

    inline fun <reified M : NetworkReceivedModel, T : MappableDAO<M>> safeApiCall(apiCall: () -> T): Result<M> {
        // Calling the apiCall method that passed as a higher order function
        val result = try {
            val response = apiCall.invoke()
            println( "safeApiCall: $response")
            Result.Data(response.map())
        } catch (e: Throwable) { // If response code is not 200 then an exception will be thrown
           println( "${e.message}")
            Result.NetworkError(e)
        }
        return result
    }
}
