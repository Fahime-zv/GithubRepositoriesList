package com.fahimezv.githubrepositorylist.presentation.ui.screen.list

import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.fahimezv.githubrepositorylist.data.network.repository.UsersRepository
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseViewModelState
import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.paging.RepositoryPagingSource

class ListViewModel(
    private val userNam: String,
    private val usersRepository: UsersRepository,
) : BaseViewModelState() {


    private lateinit var pagingSource: RepositoryPagingSource

    val repoLiveData = Pager(PagingConfig(pageSize = 30, initialLoadSize = 1)) {
        pagingSource = RepositoryPagingSource(userName = userNam, usersRepository = usersRepository)
        pagingSource
    }.liveData.cachedIn(viewModelScope)

}