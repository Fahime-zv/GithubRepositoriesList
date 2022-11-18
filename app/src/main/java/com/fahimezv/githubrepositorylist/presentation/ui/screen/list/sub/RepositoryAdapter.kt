package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.OnRepositoryClickListener
import com.fahimezv.githubrepositorylist.presentation.common.recycler.BasePagingAdapter
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet

class RepositoryAdapter(
    private val onRepositoryClickListener: OnRepositoryClickListener,
) : BasePagingAdapter<RepoCellView, Repo>(RepoComparator) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BaseViewHolder<RepoCellView> {
        val cellView = RepoCellView(
            parent.context
        ).apply {
            layoutParams = LayoutSet.Recycler.defaultParams()
        }
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


    object RepoComparator : DiffUtil.ItemCallback<Repo>() {
        override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean {
            return oldItem == newItem
        }
    }
}
