package com.fahimezv.githubrepositorylist.presentation.ui.screen.home

import android.content.Context
import android.widget.LinearLayout
import com.fahimezv.githubrepositorylist.presentation.OnUserNameClickListener
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.ui.view.CustomButton
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin

class HomeView(
    context: Context,
    private val jackClickListener: OnUserNameClickListener,
    private val infinumClickListener: OnUserNameClickListener,
) : LinearLayout(context) {

    // UI
    private val jackWhartonRepositoryButton: CustomButton.Solid
    private val infinumRepositoryButton: CustomButton.Solid

    init {
        //Setting
        orientation = VERTICAL
        //Setup JackWharton Button
        jackWhartonRepositoryButton = createJackWhartonButton()
        addView(jackWhartonRepositoryButton, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
        //Setup Infinum Button
        infinumRepositoryButton = createInfinumButton()
        addView(infinumRepositoryButton, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createJackWhartonButton() = CustomButton.Solid(context).apply {
        text = StringProvider.jackWharton
        setOnClickListener {
            jackClickListener.invoke("JakeWharton")
        }

    }

    private fun createInfinumButton() = CustomButton.Solid(context).apply {
        text = StringProvider.infinum
        setOnClickListener {
            jackClickListener.invoke("fahime-zv")
        }

    }

}