package br.com.tecapp.personproject.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.shared.manager.PhotoManagerImp
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PhotosViewModel : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()
    private val photoManager: PhotoManager = PhotoManagerImp()

    private val _photosViewModel = MutableLiveData<List<PhotoViewModel>>().apply { value = emptyList() }

    val photosViewModel: LiveData<List<PhotoViewModel>>
        get() = _photosViewModel

    fun destroy() {
        disposables.clear()
    }

    fun listPhotos() {
        disposables.add(photoManager.listPhotos()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { photos ->
                _photosViewModel.value = photos.map {
                    PhotoViewModel(it)
                }
            })
    }

}