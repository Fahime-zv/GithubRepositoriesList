package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseViewModelState

class DetailViewModel(private val repo: RepoDAO) : BaseViewModelState() {
}