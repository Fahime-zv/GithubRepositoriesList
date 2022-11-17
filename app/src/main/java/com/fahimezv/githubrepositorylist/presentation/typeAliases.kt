package com.fahimezv.githubrepositorylist.presentation

import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO

typealias OnSimpleClickListener = () -> Unit

typealias OnUserNameClickListener = (username: String) -> Unit

typealias  OnRepositoryClickListener = (repo: RepoDAO) -> Unit
