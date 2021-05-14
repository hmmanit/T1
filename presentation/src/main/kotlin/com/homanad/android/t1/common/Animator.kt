package com.homanad.android.t1.common

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.TimeInterpolator
import android.view.View
import com.google.android.material.animation.AnimationUtils
import com.homanad.android.t1.R

object Animator {

    fun showBottomBar(
        v: View,
        duration: Long = v.context.resources.getInteger(R.integer.motion_duration_medium).toLong(),
        targetY: Float = 0f,
        interpolator: TimeInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR,
        onAnimationEnd: () -> Unit
    ) {
        v.animate().translationY(targetY)
            .setInterpolator(interpolator)
            .setDuration(duration)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    onAnimationEnd()
                }
            })
    }

    fun hideBottomBar(
        v: View,
        duration: Long = v.context.resources.getInteger(R.integer.motion_duration_small).toLong(),
        targetY: Float = v.measuredHeight.toFloat(),
        interpolator: TimeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR,
        onAnimationEnd: () -> Unit
    ) {
        v.animate().translationY(targetY).setInterpolator(interpolator).setDuration(duration)
            .setListener(
                object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        onAnimationEnd()
                    }
                })
    }
}