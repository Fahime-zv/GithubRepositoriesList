package com.fahimezv.githubrepositorylist.presentation

import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel{
            parameters->
        ListViewModel( parameters[0], usersRepository = get())
    }

}