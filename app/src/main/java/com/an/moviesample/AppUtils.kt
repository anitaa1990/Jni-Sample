package com.an.moviesample

import android.content.Context
import android.graphics.Point
import android.os.Build
import android.view.Display
import android.view.WindowManager

object AppUtils {

    fun getScreenWidth(mContext: Context): Int {
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val width1: Int
        width1 = if (Build.VERSION.SDK_INT > 12) {
            val size = Point()
            display.getSize(size)
            size.x
        } else {
            display.width
        }

        return width1
    }

    fun getScreenHeight(mContext: Context): Int {
        val wm = mContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = wm.defaultDisplay
        val height1: Int
        height1 = if (Build.VERSION.SDK_INT > 12) {
            val size = Point()
            display.getSize(size)
            size.y
        } else {
            display.height
        }

        return height1
    }
}
