package br.com.tecapp.personproject.ui.photos.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class PhotosViewModel(private val photoManager: PhotoManager) : ViewModel() {

    private val disposables: CompositeDisposable = CompositeDisposable()

    var photos: MutableLiveData<List<PhotoViewModel>> = MutableLiveData()
    var error: MutableLiveData<String> = MutableLiveData()

    fun destroy() {
        disposables.clear()
    }

    fun listPhotos() {
        disposables.add(
            photoManager.listPhotos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { photos -> this.photos.value = photos },
                    { t ->
                        t.printStackTrace()
                        error.value = "Ocorreu um erro"
                    })
        )
    }

}