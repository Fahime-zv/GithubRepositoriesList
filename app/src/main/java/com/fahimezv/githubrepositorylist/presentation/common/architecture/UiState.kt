
package com.fahimezv.githubrepositorylist.presentation.common.architecture

sealed class UiState {
    object Loading : UiState()
    object Empty : UiState()
    object Data : UiState()
    object NetworkError : UiState()
    data class ApiError(val msg: String?) : UiState()

    override fun toString(): String {
        return when (this) {
            is ApiError -> "ApiError(msg: ${this.msg})"
            Data -> "Data"
            Empty -> "Empty"
            Loading -> "Loading"
            NetworkError -> "NetworkError"
        }
    }
}