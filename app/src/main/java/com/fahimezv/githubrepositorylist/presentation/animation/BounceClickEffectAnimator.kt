
package com.fahimezv.githubrepositorylist.presentation.animation

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.view.View

class BounceClickEffectAnimator(view: View, private val scaleOffSet: Float = 0.03F, private val alphaScale: Float = 0.8F) {

    private val onTouchActionDownAnimatorSet: AnimatorSet = AnimatorSet().apply {
        val xScale = ObjectAnimator.ofFloat(view, "scaleX", (1 - scaleOffSet))
        val yScale = ObjectAnimator.ofFloat(view, "scaleY", (1 - scaleOffSet))
        val alpha = ObjectAnimator.ofFloat(view, "alpha", alphaScale)
        playTogether(xScale, yScale, alpha)
    }

    private val onTouchActionUpAnimatorSet: AnimatorSet = AnimatorSet().apply {
        val xScale = ObjectAnimator.ofFloat(
            view,
            "scaleX",
            (1 - scaleOffSet),
            (1 + scaleOffSet),
            1F
        )
        val yScale = ObjectAnimator.ofFloat(
            view,
            "scaleY",
            (1 - scaleOffSet),
            (1 + scaleOffSet),
            1F
        )
        val alpha = ObjectAnimator.ofFloat(view, "alpha", alphaScale, 1F)
        playTogether(xScale, yScale, alpha)
    }

    fun touchEffect() {
        onTouchActionUpAnimatorSet.end()
        onTouchActionDownAnimatorSet.start()
    }

    fun releaseEffect() {
        onTouchActionDownAnimatorSet.end()
        onTouchActionUpAnimatorSet.start()
    }
}