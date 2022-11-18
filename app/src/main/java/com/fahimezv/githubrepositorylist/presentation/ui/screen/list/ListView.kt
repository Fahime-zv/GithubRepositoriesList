package com.fahimezv.githubrepositorylist.presentation.ui.screen.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.core.view.setPadding
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.OnRepositoryClickListener
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub.RecyclerViewDecorations
import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub.RepositoryAdapter
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet

@SuppressLint("ViewConstructor")
class ListView(
    context: Context,
    private val onRepositoryClickListener: OnRepositoryClickListener,
) : FrameLayout(context), ViewState {

    // UI
    private var recyclerView: RecyclerView
    private var loading: ProgressBar
    private var emptyView: TextView

    // Adapter
    lateinit var repositoryAdapter: RepositoryAdapter

    init {
        //Setup LoadingView
        loading = createLoadingView()
        addView(loading, LayoutSet.Frame.get(DpProvider.buttonHeight).gravity(Gravity.CENTER))
        //Setup EmptyView
        emptyView = createEmptyView()
        addView(emptyView, LayoutSet.Frame.fullScreen().gravity(Gravity.CENTER))
        //Setup RecyclerView
        recyclerView = createRecyclerView()
        addView(recyclerView, LayoutSet.Frame.fullScreen())
    }

    //****************************************
    //                UiState                *
    //****************************************

    override fun onLoading() {
        loading.isVisible = true
        emptyView.isVisible = false
        recyclerView.isVisible = false
    }

    override fun onData() {
        recyclerView.isVisible = true
        loading.isVisible = false
        emptyView.isVisible = false
    }

    override fun onEmpty() {
        recyclerView.isVisible = false
        loading.isVisible = false
        emptyView.isVisible = true
    }

    override fun onNetworkError() {
        recyclerView.isVisible = false
        loading.isVisible = false
        emptyView.isVisible = true
        emptyView.apply {
            text = StringProvider.somethingHappened
            setTextColor(ColorProvider.error)
        }

    }

    override fun onApiError(msg: String) {
        recyclerView.isVisible = false
        loading.isVisible = false
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createLoadingView() = ProgressBar(context)

    private fun createEmptyView() = TextView(context).apply {
        text = StringProvider.emptyMessage
        textSize = 10.dpToPx.toFloat()
        gravity=Gravity.CENTER
    }

    private fun createRecyclerView() = RecyclerView(context).apply {
        clipToPadding = false
        clipChildren = false
        layoutManager = LinearLayoutManager(context)
        //Setup Adapter
        repositoryAdapter = RepositoryAdapter(
            onRepositoryClickListener = onRepositoryClickListener
        )
        adapter = repositoryAdapter
        addItemDecoration(RecyclerViewDecorations.VerticalSpaceItemDecoration(DpProvider.padding))
        setPadding(DpProvider.padding2X,DpProvider.padding2X,DpProvider.padding2X,DpProvider.padding2X)

    }

    //****************************************
    //              Public Function          *
    //****************************************

    suspend fun bind(pagingData: PagingData<Repo>) {
        repositoryAdapter.submitData(pagingData)
    }

}