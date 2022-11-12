/*
 * TextViewExtensions.kt
 * NZCodebase
 *
 * Created by Parham Soltani on 3/16/2021
 * Copyright © 2021 Nizek. All rights reserved.
 */

package com.fahimezv.githubrepositorylist.presentation.extentions

import android.graphics.Color
import android.text.TextUtils
import android.util.TypedValue
import android.widget.TextView

/**
 * A convenience TextView extension to support text colors for light and dark modes by NZColor
 *
 * Example:
 * ```
 * textView.setTextColor(ColorProvider.tint)
 * ```
 * @receiver the [TextView] which you want to apply the [Color] to
 * @param color Intended text color
 * */
fun TextView.setTextColor(color: String) {
    setTextColor(Color.parseColor(color))
}
fun TextView.setBackgroundColor(color: String) {
    setBackgroundColor(Color.parseColor(color))
}
/**
 * A convenience TextView extension to apply text size in PX
 *
 * Example:
 * ```
 * textView.setTextSizeInPixel(SpProvider.General.button)
 * ```
 * @receiver the [TextView] which you want to apply the size to
 * @param px Intended text size
 * */
fun TextView.setTextSizeInPixel(px: Int) {
    setTextSize(TypedValue.COMPLEX_UNIT_PX, px.toFloat())
}

/**
 * A convenience TextView extension to apply single line for EditText and TextView
 *
 * Example:
 * ```
 * textView.applySingleLine()
 * ```
 * @receiver the [TextView] which you want to apply singleLine to
 * */
fun TextView.applySingleLine() {
    setSingleLine()
    setLines(1)
    maxLines = 1
    ellipsize = TextUtils.TruncateAt.END
}

fun TextView.applyMultiLine(lines: Int) {
    setLines(lines)
    maxLines = lines
    ellipsize = TextUtils.TruncateAt.END
}

fun TextView.applyMaxLine(lines: Int) {
    maxLines = lines
    ellipsize = TextUtils.TruncateAt.END
}