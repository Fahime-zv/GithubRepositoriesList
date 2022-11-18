package com.fahimezv.githubrepositorylist.presentation.ui.screen.list.sub

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.text.TextUtils
import android.view.MotionEvent
import android.widget.LinearLayout
import android.widget.TextView
import com.fahimezv.githubrepositorylist.core.entity.Repo
import com.fahimezv.githubrepositorylist.presentation.common.animation.BounceClickEffectAnimator
import com.fahimezv.githubrepositorylist.presentation.extentions.dpToPx
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider
import com.fahimezv.githubrepositorylist.presentation.provider.StringProvider
import com.fahimezv.githubrepositorylist.presentation.util.LayoutSet
import com.fahimezv.githubrepositorylist.presentation.util.margin
import top.defaults.drawabletoolbox.DrawableBuilder

class RepoCellView(
    context: Context,
) : LinearLayout(context) {

    // UI
    private val nameTextView: TextView
    private val urlTextView: TextView

    // Animation
    private val bounceClickEffectAnimator = BounceClickEffectAnimator(this)

    init {
        //Setting
        background = DrawableBuilder()
            .rectangle()
            .cornerRadius(DpProvider.radios)
            .solidColor(Color.parseColor(ColorProvider.white))
            .strokeColorPressed(Color.parseColor(ColorProvider.pinkLight))
            .strokeWidth(1.dpToPx)
            .strokeColor(Color.parseColor(ColorProvider.white))
            .build()
        orientation = VERTICAL
        setPadding(DpProvider.padding2X, DpProvider.padding, DpProvider.padding2X, DpProvider.padding)
        // Setup NameTextView
        nameTextView = createNameTextView()
        addView(nameTextView, LayoutSet.Linear.defaultParams().margin(0,DpProvider.padding,0,0))
        // Setup URlTextView
        urlTextView = createUrlTextView()
        addView(urlTextView, LayoutSet.Linear.defaultParams().margin(0,DpProvider.padding,0,DpProvider.padding))

    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                bounceClickEffectAnimator.touchEffect()
            }
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                bounceClickEffectAnimator.releaseEffect()
            }
        }
        return super.onTouchEvent(event)
    }

    //****************************************
    //              View Creations           *
    //****************************************

    private fun createNameTextView() = TextView(context).apply {
        textSize = 6.dpToPx.toFloat()
        setTextColor(ColorProvider.black)
        setTypeface(null, Typeface.BOLD_ITALIC)
    }

    private fun createUrlTextView() = TextView(context).apply {
        textSize = 5.dpToPx.toFloat()
        ellipsize = TextUtils.TruncateAt.END
        setTextColor(ColorProvider.gray)
        setTypeface(null, Typeface.ITALIC) // for Bold and Italic
    }

    //****************************************
    //              Public Function          *
    //****************************************

    @SuppressLint("SetTextI18n")
    fun bind(repo: Repo) {
        nameTextView.text = "${StringProvider.repositoryName}: ${repo.name}"
        urlTextView.text = "${StringProvider.repositoryUrl}: ${repo.url}"
    }


}