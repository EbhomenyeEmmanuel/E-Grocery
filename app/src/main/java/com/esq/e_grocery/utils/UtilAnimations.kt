package com.esq.e_grocery.utils

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.ScaleAnimation

object UtilAnimations {
    fun fadeInAnimation(view: View) {
        val fadeIn = AlphaAnimation(0f, 1f)
        fadeIn.duration = 2250L
        fadeIn.interpolator = DecelerateInterpolator()

        view.animation = fadeIn
    }

    fun hoverViewAnimation(view: View) {
        val hoverView = ScaleAnimation(1f, 0.97f, 1f, 0.97f, Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)

        hoverView.fillAfter = true
        hoverView.duration = 2000
        hoverView.repeatCount = Animation.INFINITE
        hoverView.repeatMode = Animation.REVERSE

        view.startAnimation(hoverView)
    }
}