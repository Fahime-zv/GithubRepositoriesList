package com.fahimezv.githubrepositorylist.data.network.repository

import android.util.Log
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.presentation.extentions.TAG

abstract class BaseRepository {
//
    inline fun <reified M : Any> safeApiCall(apiCall: () -> M): Result<M> {
        // Calling the apiCall method that passed as a higher order function
        val result = try {
            val response = apiCall.invoke()
            Result.Data(response)
        } catch (e: Throwable) { // If response code is not 200 then an exception will be thrown
            Log.e(TAG, "${e.message}")
            Result.NetworkError(e)
        }
        return result
    }

//    inline fun <reified M : List<NetworkReceivedModel>, T : MappableListDAO<M>> safeApiCall(apiCall: () -> T): Result<M> {
//        // Calling the apiCall method that passed as a higher order function
//        val result = try {
//            val response = apiCall.invoke()
//            Log.i(TAG, "safeApiCall: $response")
//           Result.Data( response.map() )
//        } catch (e: Throwable) { // If response code is not 200 then an exception will be thrown
//            Log.e(TAG, "${e.message}")
//            Result.NetworkError(e)
//        }
//        return result
//    }

}
