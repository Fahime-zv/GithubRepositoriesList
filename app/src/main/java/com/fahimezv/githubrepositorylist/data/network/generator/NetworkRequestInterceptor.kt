package com.fahimezv.githubrepositorylist.data.network.generator

import com.fahimezv.githubrepositorylist.data.network.generator.model.NetworkRequestHeader
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkRequestInterceptor(
    private val headersGenerator: NetworkHeadersGenerator) : NetworkInterceptor {

    @Throws(IOException::class)
    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        var newRequest = chain.request()
        // If request is POST request and has a body then we encrypt the body
        val requestContentLength: Long? = newRequest.body?.contentLength()
        val headers = headersGenerator.getHeaders(requestContentLength)
        newRequest = addHeadersToRequest(newRequest, headers)
        return chain.proceed(newRequest)
    }

    private fun addHeadersToRequest(
        request: Request,
        networkHeaders: List<NetworkRequestHeader>
    ): Request {
        val requestBuilder = request.newBuilder()
        networkHeaders.forEach {
            requestBuilder.addHeader(it.key, it.value)
        }
        return requestBuilder.build()
    }

}