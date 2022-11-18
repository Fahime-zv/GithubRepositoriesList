package com.fahimezv.githubrepositorylist.presentation.ui.screen.detail

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import com.fahimezv.githubrepositorylist.core.entity.Event
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin
import top.defaults.drawabletoolbox.DrawableBuilder

@SuppressLint("SetTextI18n")
class DetailView(
    context: Context,
    private val userName: String,
    private val repo: Repo,
) : FrameLayout(context), ViewState {

    //UI
    private val rootLayout: LinearLayout
    private val ownerLinearLayout: LinearLayout
    private val repoInfoLinearLayout: LinearLayout
    private val lastEventLinearLayout: LinearLayout
    private val ownerLoginTextView: TextView
    private val ownerUrlTextView: TextView
    private val repoNameTextView: TextView
    private val repoUrlTextView: TextView
    private val headerLinearLayout: LinearLayout
    private val userNameHeaderTextView: TextView
    private val typeTextView: TextView
    private val displayLoginTextView: TextView
    private val actorUrlTextView: TextView
    private val loadingView: ProgressBar
    private var emptyView: TextView
    private  val titleOfRepo:TextView
    private  val titleOfOwner:TextView
    private  val titleOfLastEvnt:TextView


    init {
        //Setup RootLayout
        rootLayout = LinearLayout(context).apply {
            //Setting
            orientation = LinearLayout.VERTICAL
            //Setup HeaderLinearLayout
            headerLinearLayout = LinearLayout(context).apply {
                background = DrawableBuilder()
                    .rectangle()
                    .cornerRadii(0, 0, DpProvider.radios, DpProvider.radios)
                    .solidColor(Color.parseColor(ColorProvider.tint))
                    .build()                //Setup userNameHeaderTextView
                userNameHeaderTextView = createHeaderNameTextView()
                addView(userNameHeaderTextView, LayoutSet.Linear.defaultParams().gravity(Gravity.CENTER))
            }

            addView(headerLinearLayout, LayoutSet.Linear.get(LayoutSet.MATCH, DpProvider.headerHeight))
            //Setup titleOfOwner
            titleOfOwner=createTitleOfOwnerTextView()
            addView(titleOfOwner,LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup OwnerLinearLayout
            ownerLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.VERTICAL
                setPadding(DpProvider.radios2X, DpProvider.padding2X, DpProvider.padding2X, DpProvider.padding2X)
                background = DrawableBuilder()
                    .rectangle()
                    .cornerRadius(DpProvider.radios)
                    .solidColor(Color.parseColor(ColorProvider.white))
                    .strokeWidth(1.dpToPx)
                    .strokeColor(Color.parseColor(ColorProvider.white))
                    .build()
                //Setup ownerLoginTextView
                ownerLoginTextView = createOwnerLoginTextView()
                addView(ownerLoginTextView, LayoutSet.Linear.defaultParams())
                //Setup ownerUrlTextView
                ownerUrlTextView = createOwnerUrlTextView()
                addView(ownerUrlTextView, LayoutSet.Linear.defaultParams().margin(0, DpProvider.padding2X, 0, 0))
            }
            addView(ownerLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup titleOfRepo
            titleOfRepo=crateTitleOfRepoTextView()
            addView(titleOfRepo,LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup OwnerLinearLayout
            repoInfoLinearLayout = LinearLayout(context).apply {
                //Setting
                orientation = LinearLayout.VERTICAL
                setPadding(DpProvider.radios2X, DpProvider.padding2X, DpProvider.padding2X, DpProvider.padding2X)
                background = DrawableBuilder()
                    .rectangle()
                    .cornerRadius(DpProvider.radios)
                    .solidColor(Color.parseColor(ColorProvider.white))
                    .strokeWidth(1.dpToPx)
                    .strokeColor(Color.parseColor(ColorProvider.white))
                    .build()
                //Setup repoNameTextView
                repoNameTextView = createRepoNameTextView()
                addView(repoNameTextView, LayoutSet.Linear.defaultParams())
                //Setup repoUrlTextView
                repoUrlTextView = createRepoUrlTextView()
                addView(repoUrlTextView, LayoutSet.Linear.defaultParams().margin(0, DpProvider.padding2X, 0, 0))

            }
            addView(repoInfoLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup titleOfLastEvent
            titleOfLastEvnt=crateTitleOfLastEventTextView()
            addView(titleOfLastEvnt,LayoutSet.Linear.defaultParams().margin(DpProvider.padding))
            //Setup lastEventLinearLayout
            lastEventLinearLayout = LinearLayout(context).apply {
                //Setting
                gravity=Gravity.CENTER
                orientation = LinearLayout.VERTICAL
                setPadding(DpProvider.radios2X, DpProvider.padding2X, DpProvider.padding2X, DpProvider.padding2X)
                background = DrawableBuilder()
                    .rectangle()
                    .cornerRadius(DpProvider.radios)
                    .solidColor(Color.parseColor(ColorProvider.white))
                    .strokeWidth(1.dpToPx)
                    .strokeColor(Color.parseColor(ColorProvider.white))
                    .build()
                //Setup LoadingView
                loadingView = createLoadingView()
                addView(loadingView, LayoutSet.Frame.get(DpProvider.buttonHeight).gravity(Gravity.CENTER))
                //Setup EmptyView
                emptyView = createEmptyView()
                addView(emptyView, LayoutSet.Frame.fullScreen().gravity(Gravity.CENTER))
                //Setup typeTextView
                typeTextView = createTextView()
                addView(typeTextView, LayoutSet.Linear.defaultParams())
                //Setup displayLoginTextView
                displayLoginTextView = createTextView()
                addView(displayLoginTextView, LayoutSet.Linear.defaultParams().margin(0, DpProvider.padding2X, 0, 0))
                //Setup actorUrlTextView
                actorUrlTextView = createTextView()
                addView(actorUrlTextView, LayoutSet.Linear.defaultParams().margin(0, DpProvider.padding2X, 0, 0))
            }
            addView(lastEventLinearLayout, LayoutSet.Linear.defaultParams().margin(DpProvider.padding))

        }
        addView(rootLayout, LayoutSet.Frame.fullScreen())

    }


    //****************************************
    //                UiState                *
    //****************************************

    override fun onLoading() {
        loadingView.isVisible = true
        emptyView.isVisible = false
    }

    override fun onData() {
        typeTextView.isVisible = true
        displayLoginTextView.isVisible = true
        actorUrlTextView.isVisible = true
        loadingView.isVisible = false
        emptyView.isVisible = false
    }

    override fun onEmpty() {
        loadingView.isVisible = false
        emptyView.isVisible = true
    }

    override fun onNetworkError() {
        loadingView.isVisible = false
        emptyView.isVisible = true
        emptyView.apply {
            text = StringProvider.somethingHappened
            setTextColor(ColorProvider.error)
        }

    }

    override fun onApiError(msg: String) {
        loadingView.isVisible = false
        emptyView.isVisible = true
        emptyView.apply {
            text = StringProvider.somethingHappened
            setTextColor(ColorProvider.error)
        }
    }


    //****************************************
    //              View Creations           *
    //****************************************

    private fun createOwnerLoginTextView() = TextView(context).apply {
        text = " ${StringProvider.ownerLogin}   ${repo.owner.login}"
    }

    private fun createOwnerUrlTextView() = TextView(context).apply {
        text = " ${StringProvider.ownerUrl}   ${repo.owner.url}"
    }

    private fun createRepoNameTextView() = TextView(context).apply {
        text = " ${StringProvider.repoName}   ${repo.name}"
    }

    private fun createRepoUrlTextView() = TextView(context).apply {
        text = " ${StringProvider.repoUrl}   ${repo.url}"
    }

    private fun createTextView() = TextView(context).apply {
        isVisible = false
    }

    private fun createHeaderNameTextView() = TextView(context).apply {
        textSize = 12.dpToPx.toFloat()
        setTextColor(ColorProvider.white)
        setTypeface(null, Typeface.BOLD)
        text = userName
        textAlignment = TEXT_ALIGNMENT_CENTER

    }

    private fun createLoadingView() = ProgressBar(context)

    private fun createEmptyView() = TextView(context).apply {
        text = StringProvider.eventIsntAvalable
        textSize = 10.dpToPx.toFloat()
        gravity = Gravity.CENTER
        isVisible=false
    }

    private  fun crateTitleOfLastEventTextView()=TextView(context).apply {
        setTypeface(null, Typeface.BOLD)
        textSize = 6.dpToPx.toFloat()
        text=StringProvider.lastEvent
    }
    private  fun crateTitleOfRepoTextView()=TextView(context).apply {
        setTypeface(null, Typeface.BOLD)
        textSize = 6.dpToPx.toFloat()
        text=StringProvider.repo

    }
    private  fun createTitleOfOwnerTextView()=TextView(context).apply {
        setTypeface(null, Typeface.BOLD)
        textSize = 6.dpToPx.toFloat()
        text=StringProvider.owner
    }

    //****************************************
    //              Public Function          *
    //****************************************

    @SuppressLint("SetTextI18n")
    fun bind(event: Event) {
        typeTextView.text = "${StringProvider.typr}:    ${event.type}"
        displayLoginTextView.text = "${StringProvider.displayLogin}:    ${event.actor.display_login}"
        actorUrlTextView.text = "${StringProvider.actorUrl}:    ${event.actor.url}"
    }
}