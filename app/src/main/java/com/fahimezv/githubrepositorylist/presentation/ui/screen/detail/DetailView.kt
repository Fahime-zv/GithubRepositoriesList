package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin
import top.defaults.drawabletoolbox.DrawableBuilder

class DetailView(
    context: Context,
    private val userName: String,
    private val repo: Repo,
) : FrameLayout(context), ViewState {

    //UI
    private val rootLayout: LinearLayout
    private val ownerLinearLayout: LinearLayout
    private val repoInfoLinearLayout: LinearLayout
    private val ownerLoginTextView: TextView
    private val ownerUrlTextView: TextView
    private val repoNameTextView: TextView
    private val repoUrlTextView: TextView
    private val headerLinearLayout: LinearLayout
    private val userNameHeaderTextView: TextView


    init {
        //Setup RootLayout
        rootLayout = LinearLayout(context).apply {
            //Setting
            orientation = LinearLayout.VERTICAL
            //Setup HeaderLinearLayout
            headerLinearLayout = LinearLayout(context).apply {
                background= DrawableBuilder()
                    .rectangle()
                    .cornerRadii(0,0,DpProvider.radios,DpProvider.radios)
                    .solidColor(Color.parseColor(ColorProvider.tint))
                    .build()                //Setup userNameHeaderTextView
                userNameHeaderTextView = createHeaderNameTextView()
                addView(userNameHeaderTextView, LayoutSet.Linear.defaultParams().gravity(Gravity.CENTER))
            }
            addView(headerLinearLayout, LayoutSet.Linear.get(LayoutSet.MATCH, DpProvider.headerHeight))
            //Setup OwnerLinearLayout
            ownerLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.HORIZONTAL
                background = DrawableBuilder()
                    .rectangle()
                    .cornerRadius(DpProvider.radios)
                    .strokeColorPressed(Color.parseColor(ColorProvider.pinkLight))
                    .strokeWidth(1.dpToPx)
                    .strokeColor(Color.parseColor(ColorProvider.pinkLight))
                    .build()
                //Setup ownerLoginTextView
                ownerLoginTextView = createOwnerLoginTextView()
                addView(ownerLoginTextView, LayoutSet.Linear.availableWidthParams())
                //Setup ownerUrlTextView
                ownerUrlTextView = createOwnerUrlTextView()
                addView(ownerUrlTextView, LayoutSet.Linear.availableWidthParams())
            }
            addView(ownerLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup OwnerLinearLayout
            repoInfoLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.HORIZONTAL
                //Setup repoNameTextView
                repoNameTextView = createRepoNameTextView()
                addView(repoNameTextView, LayoutSet.Linear.availableWidthParams())
                //Setup repoUrlTextView
                repoUrlTextView = createRepoUrlTextView()
                addView(repoUrlTextView, LayoutSet.Linear.availableWidthParams())
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

    private fun createOwnerLoginTextView() = TextView(context).apply {
        text = repo.owner.login
    }

    private fun createOwnerUrlTextView() = TextView(context).apply {
        text = repo.owner.url
    }

    private fun createRepoNameTextView() = TextView(context).apply {
        text = repo.name
    }

    private fun createRepoUrlTextView() = TextView(context).apply {
        text = repo.url
    }

    private fun createHeaderNameTextView() = TextView(context).apply {
        textSize = 12.dpToPx.toFloat()
        setTextColor(ColorProvider.white)
        setTypeface(null, Typeface.BOLD)
        text = userName
        textAlignment = TEXT_ALIGNMENT_CENTER

    }
}