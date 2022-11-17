package com.fahimezv.githubrepositorylist.presentation.common.recycler

import android.view.View
import androidx.annotation.CallSuper
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fahimezv.githubrepositorylist.core.entity.NetworkReceivedModel

abstract class BasePagingAdapter<V : View, M : Any>(comparator: DiffUtil.ItemCallback<M>) :
    PagingDataAdapter<M, BasePagingAdapter<V, M>.BaseViewHolder<V>>(comparator) {

    open fun onAdapterItemClick(adapterPosition: Int) {
        // Override if you need this
    }

    open fun onAdapterItemLongClick(adapterPosition: Int) {
        // Override if you need this
    }

    @CallSuper
    override fun onBindViewHolder(holder: BaseViewHolder<V>, position: Int) {
        holder.cellView.setOnClickListener {
            onAdapterItemClick(holder.bindingAdapterPosition)
        }
        holder.cellView.setOnLongClickListener {
            onAdapterItemLongClick(holder.bindingAdapterPosition)
            return@setOnLongClickListener true
        }
    }

    inner class BaseViewHolder<T : View>(val cellView: T) : RecyclerView.ViewHolder(cellView)

}