package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin

class DetailView(
    context: Context,
    private val repo: Repo,
) : FrameLayout(context), ViewState {

    //UI
    private val rootLayout: LinearLayout
    private val ownerLinearLayout: LinearLayout
    private val repoInfoLinearLayout: LinearLayout
    private val ownerLoginTextView:TextView
    private val ownerUrlTextView:TextView
    private val repoNameTextView:TextView
    private val repoUrlTextView:TextView


    init {
        //Setup RootLayout
        rootLayout = LinearLayout(context).apply {
            //Setting
            orientation = LinearLayout.VERTICAL
            //Setup OwnerLinearLayout
            ownerLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.HORIZONTAL
                //Setup ownerLoginTextView
                ownerLoginTextView=createOwnerLoginTextView()
                addView(ownerLoginTextView,LayoutSet.Linear.availableWidthParams())
                //Setup ownerUrlTextView
                ownerUrlTextView=createOwnerUrlTextView()
                addView(ownerUrlTextView,LayoutSet.Linear.availableWidthParams())
            }
            addView(ownerLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup OwnerLinearLayout
            repoInfoLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.HORIZONTAL
                //Setup repoNameTextView
                repoNameTextView=createRepoNameTextView()
                addView(repoNameTextView,LayoutSet.Linear.availableWidthParams())
                //Setup repoUrlTextView
                repoUrlTextView=createRepoUrlTextView()
                addView(repoUrlTextView,LayoutSet.Linear.availableWidthParams())
            }
            addView(repoInfoLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
        }
        addView(rootLayout, LayoutSet.Frame.fullScreen())

    }


    //****************************************
    //                UiState                *
    //****************************************
    override fun onLoading() {
    }

    override fun onEmpty() {
    }

    override fun onData() {
    }

    override fun onNetworkError() {
    }

    override fun onApiError(msg: String) {
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createOwnerLoginTextView()=TextView(context).apply {
        text = repo.owner.login
    }
    private fun createOwnerUrlTextView()=TextView(context).apply {
        text = repo.owner.url
    }
    private fun createRepoNameTextView()=TextView(context).apply {
        text = repo.name
    }
    private fun createRepoUrlTextView()=TextView(context).apply {
        text = repo.url
    }
}