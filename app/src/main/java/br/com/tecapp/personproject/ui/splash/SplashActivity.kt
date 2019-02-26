package br.com.tecapp.personproject.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import br.com.tecapp.personproject.R
import br.com.tecapp.personproject.databinding.SplashScreenBinding
import br.com.tecapp.personproject.ui.photos.list.PhotoListActivity
import kotlinx.android.synthetic.main.splash_screen.*

class SplashActivity : AppCompatActivity() {

    val viewModel: SplashViewModel =
        SplashViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding: SplashScreenBinding = DataBindingUtil.setContentView(this, R.layout.splash_screen)
        viewBinding.viewModel = viewModel

        setupBindings()
    }

    private fun setupBindings() {
        viewModel.openPhotosView
            .observe(this, Observer {
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, btnGo, "transition")
                val revealX = (btnGo.x + btnGo.width / 2).toInt()
                val revealY = (btnGo.y + btnGo.height / 2).toInt()

                val intent = Intent(this, PhotoListActivity::class.java)
                intent.putExtra(PhotoListActivity.EXTRA_CIRCULAR_REVEAL_X, revealX)
                intent.putExtra(PhotoListActivity.EXTRA_CIRCULAR_REVEAL_Y, revealY)

                ActivityCompat.startActivity(this, intent, options.toBundle())
            })
    }

}
