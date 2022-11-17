package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.fahimezv.githubrepositorylist.data.network.model.Result
import com.fahimezv.githubrepositorylist.data.network.model.dao.EventDAO
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.data.network.repository.RepoRepository
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseViewModelState
import com.fahimezv.githubrepositorylist.presentation.common.architecture.UiState
import kotlinx.coroutines.launch

class DetailViewModel(
    private val repo: RepoDAO,
    private val userName: String,
    private val repoRepository: RepoRepository,
) : BaseViewModelState() {

    private val eventLiveData = MutableLiveData<EventDAO>()
    fun getEventLiveData(): LiveData<EventDAO> = eventLiveData

    init {
        requestLastEvent()
    }

    private fun requestLastEvent() {
        viewModelScope.launch {
            uiState(UiState.Loading)
            with(repoRepository.events(userName, repo.name)) {
                when (this) {
                    is Result.Data -> {
                         if(this.model.isNotEmpty())
                        eventLiveData.postValue(  this.model.first())
                    }
                    is Result.NetworkError -> {
                    }

                }
            }
            uiState(UiState.Data)
        }
    }
}