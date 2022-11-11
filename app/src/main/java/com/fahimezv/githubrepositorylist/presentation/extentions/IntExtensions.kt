package com.fahimezv.githubrepositorylist.presentation.extentions

import android.content.res.Resources

/**
 * A convenience Int property extension to convert intended size from Pixels to Dp scale
 *
 * Example:
 * ```
 * val sizeInDp = 400.pxToDp
 * ```
 * @receiver intended size in pixels
 * @return converted value from Px to Dp scale
 * */
val Int.pxToDp: Int
    get() = (this / Resources.getSystem().displayMetrics.density).toInt()

/**
 * A convenience Int property extension to convert intended size from DpScale to Pixels
 *
 * Example:
 * ```
 * view.setPadding(8.dpToPx)
 * ```
 * @receiver intended size in DpScale
 * @return converted value from Dp scale to Px
 * */
val Int.dpToPx: Int
    get() = (this * Resources.getSystem().displayMetrics.density).toInt()