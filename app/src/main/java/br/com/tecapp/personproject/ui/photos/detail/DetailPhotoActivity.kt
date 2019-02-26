package br.com.tecapp.personproject.ui.photos.detail

import android.os.Bundle
import android.transition.Fade
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import br.com.tecapp.personproject.R
import br.com.tecapp.personproject.databinding.DetailPhotoScreenBinding
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import br.com.tecapp.personproject.utils.DeviceUtils

class DetailPhotoActivity : AppCompatActivity() {

    companion object {
        const val PHOTO_ARGS = "photo_args"
    }

    private lateinit var detailViewModel: DetailPhotoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupExtras()

        val viewBinding: DetailPhotoScreenBinding = DataBindingUtil.setContentView(this, R.layout.detail_photo_screen)
        viewBinding.viewModel = detailViewModel

        setupAnimation()
        setupBinding()
    }

    override fun onDestroy() {
        super.onDestroy()
        detailViewModel.destroy()
    }

    private fun setupExtras() {
        if (intent.hasExtra(PHOTO_ARGS)) {
            val photoViewModel: PhotoViewModel = intent.getSerializableExtra(PHOTO_ARGS) as PhotoViewModel
            detailViewModel = DetailPhotoViewModel(photoViewModel)
        }
    }

    private fun setupAnimation() {
        val enterTransition = Fade()
        enterTransition.duration = 300
        window.enterTransition = enterTransition
    }

    private fun setupBinding() {
        detailViewModel.postPhotoUrl
            .observe(this, Observer {
                DeviceUtils.openBrowserUrl(this, it)
            })

        detailViewModel.authorUrl
            .observe(this, Observer {
                DeviceUtils.openBrowserUrl(this, it)
            })
    }
}
