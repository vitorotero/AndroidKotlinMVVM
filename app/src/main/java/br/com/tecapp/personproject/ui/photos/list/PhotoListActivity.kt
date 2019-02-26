package br.com.tecapp.personproject.ui.photos.list

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tecapp.personproject.R
import br.com.tecapp.personproject.databinding.PhotoListScreenBinding
import br.com.tecapp.personproject.ui.photos.detail.DetailPhotoActivity
import br.com.tecapp.personproject.ui.photos.list.adapter.PhotoAdapter
import br.com.tecapp.personproject.ui.photos.list.adapter.PhotoAdapterListenner
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import br.com.tecapp.personproject.utils.DeviceUtils
import br.com.tecapp.personproject.utils.TransictionsUtils
import kotlinx.android.synthetic.main.photo_list_screen.*
import java.io.Serializable


class PhotoListActivity : AppCompatActivity(), PhotoAdapterListenner {

    companion object {
        const val EXTRA_CIRCULAR_REVEAL_X = "EXTRA_CIRCULAR_REVEAL_X"
        const val EXTRA_CIRCULAR_REVEAL_Y = "EXTRA_CIRCULAR_REVEAL_Y"
    }

    private val photosViewModel = PhotosViewModel()
    private var revealX: Int = 0
    private var revealY: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding: PhotoListScreenBinding = DataBindingUtil.setContentView(this, R.layout.photo_list_screen)
        viewBinding.viewModel = photosViewModel
        viewBinding.rvPhotos.adapter = PhotoAdapter(emptyList(), this)
        viewBinding.rvPhotos.layoutManager = LinearLayoutManager(this)

        setupTransaction()
        setupBinding()
        photosViewModel.listPhotos()
    }

    override fun onBackPressed() {
        TransictionsUtils.unRevealActivity(clContent, revealX, revealY, 0f, 400) {
            clContent.visibility = View.INVISIBLE
        }
        super.onBackPressed()
    }

    override fun onDestroy() {
        super.onDestroy()
        photosViewModel.destroy()
    }

    override fun openUrlAuthor(url: String) {
        DeviceUtils.openBrowserUrl(this, url)
    }

    override fun openDetail(photoViewModel: PhotoViewModel) {
        val intent = Intent(this, DetailPhotoActivity::class.java)
        intent.putExtra(DetailPhotoActivity.PHOTO_ARGS, photoViewModel)
        startActivity(intent)
    }

    private fun setupTransaction() {
        if (intent.hasExtra(EXTRA_CIRCULAR_REVEAL_X) && intent.hasExtra(EXTRA_CIRCULAR_REVEAL_Y)) {
            revealX = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_X, 0)
            revealY = intent.getIntExtra(EXTRA_CIRCULAR_REVEAL_Y, 0)

            val viewTreeObserver = clContent.viewTreeObserver
            if (viewTreeObserver.isAlive) {
                viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        val radius = (Math.max(clContent.width, clContent.height) * 1.1).toFloat()
                        TransictionsUtils.revealActivity(clContent, revealX, revealY, radius, 400)
                        clContent.viewTreeObserver.removeOnGlobalLayoutListener(this)
                    }
                })
            }
        }
    }

    private fun setupBinding() {
        photosViewModel.photosViewModel
            .observe(this, Observer {
                (rvPhotos.adapter as PhotoAdapter).photos = it
                (rvPhotos.adapter as PhotoAdapter).notifyDataSetChanged()
            })
    }

}
