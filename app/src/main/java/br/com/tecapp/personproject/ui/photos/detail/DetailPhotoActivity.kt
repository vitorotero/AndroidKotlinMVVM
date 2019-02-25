package br.com.tecapp.personproject.ui.photos.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.tecapp.personproject.R
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel

class DetailPhotoActivity : AppCompatActivity() {

    companion object {
        const val PHOTO_ARGS = "photo_args"
    }

    lateinit var photoViewModel: PhotoViewModel
    val detailViewModel: DetailPhotoViewModel = DetailPhotoViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_photo_screen)

        if (intent.hasExtra(PHOTO_ARGS)) {

        }

    }
}
