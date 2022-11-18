package com.fahimezv.githubrepositorylist.presentation

import com.fahimezv.githubrepositorylist.core.entity.Repo

typealias OnSimpleClickListener = () -> Unit

typealias OnUserNameClickListener = (username: String) -> Unit

typealias  OnRepositoryClickListener = (repo: Repo) -> Unit
