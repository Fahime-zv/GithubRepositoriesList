
package com.fahimezv.githubrepositorylist.presentation.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.fahimezv.githubrepositorylist.presentation.extentions.setTextColor
import com.fahimezv.githubrepositorylist.presentation.provider.ColorProvider
import com.fahimezv.githubrepositorylist.presentation.common.animation.BounceClickEffectAnimator
import com.fahimezv.githubrepositorylist.presentation.extentions.setBackgroundColor
import com.fahimezv.githubrepositorylist.presentation.provider.DpProvider

@SuppressLint("ViewConstructor")
abstract class CustomButton(context: Context) : AppCompatTextView(context) {

    // Animation
    private val bounceClickEffectAnimator by lazy { BounceClickEffectAnimator(this) }

    init {
        gravity = Gravity.CENTER
        textAlignment = View.TEXT_ALIGNMENT_CENTER
        minimumHeight = DpProvider.buttonHeight
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

    open class Solid(context: Context) : CustomButton(context) {
        init {
            setTextColor(ColorProvider.white)
            setBackgroundColor(ColorProvider.tint)
        }

    }

}