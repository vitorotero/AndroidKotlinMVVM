package br.com.tecapp.personproject.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

class BindingAdapters {

    companion object {

        @BindingAdapter("android:loadImageWithGlide", "android:progressViewGlide")
        @JvmStatic
        fun loadImage(view: AppCompatImageView, url: String, progressView: ProgressBar?) {
            progressView?.let {
                it.visibility = View.VISIBLE
            }
            Glide.with(view)
                .load(url)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return true
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: com.bumptech.glide.request.target.Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        progressView?.let {
                            it.visibility = View.GONE
                        }

                        view.setImageDrawable(resource!!)
                        return true
                    }
                })
                .centerCrop()
                .into(view)
        }

    }

}