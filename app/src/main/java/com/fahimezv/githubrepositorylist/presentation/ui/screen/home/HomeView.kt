package com.fahimezv.githubrepositorylist.presentation.ui.screen.home

import android.content.Context
import android.widget.LinearLayout
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.ui.view.CustomeButton
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin

class HomeView(context: Context) : LinearLayout(context) {

    // UI
    private val jackWhartonRepositoryButton: CustomeButton.Solid
    private val infinumRepositoryButton: CustomeButton.Solid

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

    private fun createJackWhartonButton() = CustomeButton.Solid(context).apply {
        text = StringProvider.jackWharton

    }
    private fun createInfinumButton() = CustomeButton.Solid(context).apply {
        text = StringProvider.infinum

    }

}