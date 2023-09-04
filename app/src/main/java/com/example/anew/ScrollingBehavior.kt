package com.example.anew

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView

class ScrollingBehavior(context: Context, attrs: AttributeSet) : CoordinatorLayout.Behavior<View>(context, attrs) {
    private var isHidden = false

    override fun layoutDependsOn(parent: CoordinatorLayout, child: View, dependency: View): Boolean {
        return dependency is NestedScrollView || dependency is RecyclerView
    }

    override fun onStartNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        directTargetChild: View,
        target: View,
        axes: Int,
        type: Int
    ): Boolean {
        return axes == ViewCompat.SCROLL_AXIS_VERTICAL
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: View,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        if (dyConsumed > 0 && !isHidden) {
            // Scrolling up, hide the bottom bar
            hideBottomBar(child)
        } else if (dyConsumed < 0 && isHidden) {
            // Scrolling down, show the bottom bar
            showBottomBar(child)
        }
    }

    private fun hideBottomBar(bottomBar: View) {
        bottomBar.animate().translationY(bottomBar.height.toFloat())
        isHidden = true
    }

    private fun showBottomBar(bottomBar: View) {
        bottomBar.animate().translationY(0f)
        isHidden = false
    }
}
