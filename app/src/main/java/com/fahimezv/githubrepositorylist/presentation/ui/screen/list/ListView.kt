package com.fahimezv.githubrepositorylist.presentation.ui.screen.list

import android.content.Context
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.presentation.OnRepositoryClickListener
import com.fahimezv.githubrepositorylist.presentation.common.architecture.ViewState
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub.RecyclerViewDecorations
import com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub.RepositoryAdapter
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet

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
        addView(loading, LayoutSet.Frame.fullScreen())
        //Setup EmptyView
        emptyView = createEmptyView()
        addView(emptyView, LayoutSet.Frame.fullScreen())
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
    }

    override fun onApiError(msg: String) {
        recyclerView.isVisible = false
        loading.isVisible = false
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createLoadingView() = ProgressBar(context).apply {
    }

    private fun createEmptyView() = TextView(context).apply {
        text = StringProvider.emptyMessage
        textSize = 12.dpToPx.toFloat()
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
        addItemDecoration(
            RecyclerViewDecorations.NoLastItemDividerDecorator(
                context,
                LinearLayout.VERTICAL
            )
        )
    }

    //****************************************
    //              Public Function          *
    //****************************************
    suspend fun bind(pagingData: PagingData<RepoDAO>) {
        repositoryAdapter.submitData(pagingData)

    }


}