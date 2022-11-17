package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin

class DetailView(
    context: Context,
    private val repoDAO: RepoDAO,
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
        TODO("Not yet implemented")
    }

    override fun onEmpty() {
        TODO("Not yet implemented")
    }

    override fun onData() {
        TODO("Not yet implemented")
    }

    override fun onNetworkError() {
        TODO("Not yet implemented")
    }

    override fun onApiError(msg: String) {
        TODO("Not yet implemented")
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createOwnerLoginTextView()=TextView(context).apply {
        text=repoDAO.owner.login
    }
    private fun createOwnerUrlTextView()=TextView(context).apply {
        text=repoDAO.owner.url
    }
    private fun createRepoNameTextView()=TextView(context).apply {
        text=repoDAO.name
    }
    private fun createRepoUrlTextView()=TextView(context).apply {
        text=repoDAO.url
    }
}