package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.presentation.OnRepositoryClickListener
import com.fahimezv.githubrepositorylist.presentation.common.recycler.BasePagingAdapter

class RepositoryAdapter(
    private val onRepositoryClickListener: OnRepositoryClickListener)
    : BasePagingAdapter<RepoCellView, RepoDAO>(RepoComparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<RepoCellView> {
        val cellView = RepoCellView(
            parent.context
        )
        return BaseViewHolder(cellView)
    }

    override fun onAdapterItemClick(adapterPosition: Int) {
        super.onAdapterItemClick(adapterPosition)
        getItem(adapterPosition)?.let {
            onRepositoryClickListener.invoke(it)
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<RepoCellView>, position: Int) {
        super.onBindViewHolder(holder, position)
        getItem(position)?.let { repo ->
            holder.cellView.bind(repo)
        }
    }


    object RepoComparator : DiffUtil.ItemCallback<RepoDAO>() {
        override fun areItemsTheSame(oldItem: RepoDAO, newItem: RepoDAO): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RepoDAO, newItem: RepoDAO): Boolean {
            return oldItem == newItem
        }
    }
}
