package com.fahimezv.githubrepositorylist.presentation.ui

import android.graphics.Color
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.fragment.NavHostFragment
import com.fahimezv.githubrepositorylist.R
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet

class MainView(fragment: FragmentActivity) : FrameLayout(fragment) {

    // UI
    private val fragmentContainerView: FragmentContainerView

    private val navHostFragment = NavHostFragment.create(R.navigation.navigation_main)

    init {

        //Setup Fragment Container View
        fragmentContainerView = createFragmentContainerView()
        addView(fragmentContainerView, LayoutSet.Frame.fullScreen())
        // Setup Fragment Container
        fragment.supportFragmentManager.beginTransaction()
            .replace(fragmentContainerView.id, navHostFragment)
            .setPrimaryNavigationFragment(navHostFragment)
            .commit()
    }

    private fun createFragmentContainerView() = FragmentContainerView(context).apply {
        id = View.generateViewId()
        setBackgroundColor(Color.GREEN)
    }
}

