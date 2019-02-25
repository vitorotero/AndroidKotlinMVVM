package br.com.tecapp.personproject.utils

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingAdapters {

    companion object {

        @BindingAdapter("android:loadImageWithGlide")
        @JvmStatic
        fun loadImage(view: AppCompatImageView, url: String) {
            Glide.with(view)
                .load(url)
                .centerCrop()
                .into(view)
        }

    }

}