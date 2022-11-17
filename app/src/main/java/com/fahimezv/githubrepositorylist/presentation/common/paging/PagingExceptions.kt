

package com.fahimezv.githubrepositorylist.presentation.common.paging

class PagingExceptions {
    class EmptyException : Throwable()

    class NetworkErrorException : Throwable()

    class ApiErrorException(val code: Int, val msg: String?) : Throwable("message: $msg")
}