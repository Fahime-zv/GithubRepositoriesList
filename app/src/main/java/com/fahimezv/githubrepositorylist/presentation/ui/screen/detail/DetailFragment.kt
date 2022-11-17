package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseFragmentVMState
import org.koin.android.ext.android.inject

class DetailFragment : BaseFragmentVMState<DetailView, DetailViewModel>() {

    //ViewModel
    override val viewModel: DetailViewModel by inject()

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): DetailView {
        return DetailView(context = requireContext())
    }
}