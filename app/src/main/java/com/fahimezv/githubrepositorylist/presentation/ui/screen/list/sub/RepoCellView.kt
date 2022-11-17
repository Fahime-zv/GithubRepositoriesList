package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub

import android.content.Context
import android.graphics.Color
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.data.network.model.dao.RepoDAO
import com.fahimezv.githubrepositorylist.presentation.OnRepositoryClickListener
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet

class RepoCellView(
    context: Context
) : LinearLayout(context) {

    // UI
    private val nameTextView: TextView
    private val urlTextView: TextView

    init {
        //Setting
        orientation = VERTICAL
        // Setup NameTextView
        nameTextView = createNameTextView()
        addView(nameTextView, LayoutSet.Linear.defaultParams())
        // Setup URlTextView
        urlTextView = createUrlTextView()
        addView(urlTextView, LayoutSet.Linear.defaultParams())

    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createNameTextView() = TextView(context).apply {
        textSize = 10.dpToPx.toFloat()
        setTextColor(Color.BLACK)

    }

    private fun createUrlTextView() = TextView(context).apply {
        textSize = 5.dpToPx.toFloat()
        ellipsize = TextUtils.TruncateAt.END
        setTextColor(Color.RED)
    }

    //****************************************
    //              Public Function          *
    //****************************************

    fun bind(repo: RepoDAO) {
        nameTextView.text = repo.name
        urlTextView.text = repo.url
    }


}