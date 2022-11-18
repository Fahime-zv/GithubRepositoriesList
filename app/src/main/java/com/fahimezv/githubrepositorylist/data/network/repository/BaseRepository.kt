package com.fahimezv.githubrepositorylist.data.network.repository

import com.fahimezv.githubrepositorylist.data.network.model.Result

abstract class BaseRepository {

    inline fun <reified M : Any> safeApiCall(apiCall: () -> M): Result<M> {
        // Calling the apiCall method that passed as a higher order function
        val result = try {
            val response = apiCall.invoke()
            Result.Data(response)
        } catch (e: Throwable) { // If response code is not 200 then an exception will be thrown
            println("${e.message}")
            Result.NetworkError(e)
        }
        return result
    }


}
