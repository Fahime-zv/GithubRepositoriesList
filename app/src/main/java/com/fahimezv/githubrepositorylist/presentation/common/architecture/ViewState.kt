
package com.fahimezv.githubrepositorylist.presentation.common.architecture


interface ViewState {
    fun onLoading()
    fun onEmpty()
    fun onData()
    fun onNetworkError()
    fun onApiError(msg: String)
}