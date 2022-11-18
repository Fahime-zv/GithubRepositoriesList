package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewDecorations {

    class VerticalSpaceItemDecoration(
        private val margin: Int = 0
    ) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            val itemPosition = parent.getChildAdapterPosition(view)
            if (itemPosition == RecyclerView.NO_POSITION)
                return

            val isFirstItem = itemPosition == 0
            outRect.top = if (isFirstItem) 0 else margin
        }

    }
}



