package com.hana.umuljeong.ui.component.imagepicker

import android.content.Context
import android.net.Uri

internal class ImageRepository(
    private val context: Context
) {
    fun getImages(): List<ImageInfo> {
        return ImageLoader.load(context)
    }

    fun insertImage(): Uri? {
        return ImageLoader.insertImage(context)
    }
}