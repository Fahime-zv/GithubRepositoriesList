package com.fahimezv.githubrepositorylist.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fahimezv.githubrepositorylist.presentation.architecture.BaseFragment

class HomeFragment : BaseFragment<HomeView>() {

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): HomeView {
        return HomeView(requireContext())
    }
}