package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.content.Context
import android.widget.FrameLayout
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState

class DetailView(context: Context):FrameLayout(context),ViewState{


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
}