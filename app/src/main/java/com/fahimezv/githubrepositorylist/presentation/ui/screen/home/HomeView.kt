package com.fahimezv.githubrepositorylist.presentation.ui.screen.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.R
import com.fahimezv.githubrepositorylist.presentation.OnUserNameClickListener
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.ui.view.CustomButton
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin

@SuppressLint("ViewConstructor")
class HomeView(
    context: Context,
    private val onUserClickListener: OnUserNameClickListener,
) : LinearLayout(context) {

    // UI
    private val jackWhartonRepositoryButton: CustomButton.Solid
    private val infinumRepositoryButton: CustomButton.Solid
    private  val headerImageView:ImageView
    private val welcomeTextView: TextView
    private val seeRepositoeyTextView: TextView


    init {
        //Setting
        orientation = VERTICAL
        //Setup Header ImageViwe
        headerImageView=createHeaderImageView()
        addView(headerImageView,LayoutSet.Linear.get(LayoutSet.MATCH,DpProvider.imageHeight))
        // Setup welcomeTextView
        welcomeTextView = createWelcomeTextView()
        addView(welcomeTextView, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
        // Setup seeRepositoeyTextView
        seeRepositoeyTextView = createSeeRepositoryTextView()
        addView(seeRepositoeyTextView, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
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
            onUserClickListener.invoke(StringProvider.jackWhartonUserName)
        }
    }

    private fun createInfinumButton() = CustomButton.Solid(context).apply {
        text = StringProvider.infinum
        setOnClickListener {
            onUserClickListener.invoke(StringProvider.infiumUserName)
        }

    }

    private  fun createHeaderImageView()=ImageView(context).apply {
        setImageResource(R.drawable.github)
        setBackgroundColor(Color.RED)
        scaleType=ImageView.ScaleType.FIT_XY
    }

    private fun createWelcomeTextView() = TextView(context).apply {
        textSize = 8.dpToPx.toFloat()
        setTextColor(ColorProvider.black)
        setTypeface(null, Typeface.BOLD_ITALIC)
        text=StringProvider.welcom
        textAlignment= TEXT_ALIGNMENT_CENTER
    }

    private fun createSeeRepositoryTextView() = TextView(context).apply {
        textSize = 6.dpToPx.toFloat()
        setTextColor(ColorProvider.gray)
        setTypeface(null, Typeface.ITALIC) // for Bold and Italic
        text=StringProvider.youCanseeRepositories
        textAlignment= TEXT_ALIGNMENT_CENTER

    }

}