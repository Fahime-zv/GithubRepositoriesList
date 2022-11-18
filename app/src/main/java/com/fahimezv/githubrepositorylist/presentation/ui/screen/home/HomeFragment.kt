package com.fahimezv.githubrepositorylist.presentation.ui.screen.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import com.fahimezv.githubrepositorylist.presentation.common.architecture.BaseFragment

class HomeFragment : BaseFragment<HomeView>() {

    override fun onCreateRootView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): HomeView {
        return HomeView(
            context = requireContext(),
            onUserClickListener = { userName ->
                navigate(HomeFragmentDirections.actionHomeFragmentToListFragment(userName))
            }
        )
    }
}