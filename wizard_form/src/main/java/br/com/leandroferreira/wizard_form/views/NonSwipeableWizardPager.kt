package br.com.leandroferreira.wizard_form.views

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.DecelerateInterpolator
import android.widget.Scroller

class NonSwipeableWizardPager(context: Context, attrs: AttributeSet) : WizardPager(context, attrs) {

    init {
        setMyScroller()
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Never allow swiping to switch between pages
        return false
    }


    private fun setMyScroller() {
        val viewpager = ViewPager::class.java
        val scroller = viewpager.getDeclaredField("mScroller")
        scroller.isAccessible = true
        scroller.set(this, MyScroller(context))
    }

    inner class MyScroller(context: Context) : Scroller(context, DecelerateInterpolator()) {
        override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
            super.startScroll(startX, startY, dx, dy, 350 /*1 secs*/)
        }
    }
}