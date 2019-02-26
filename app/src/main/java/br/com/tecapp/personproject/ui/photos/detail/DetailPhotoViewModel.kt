package br.com.tecapp.personproject.ui.photos.detail

import androidx.databinding.BaseObservable
import androidx.lifecycle.MutableLiveData
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel

class DetailPhotoViewModel(val photoViewModel: PhotoViewModel) : BaseObservable() {

    var authorUrl = MutableLiveData<String>()
    var postPhotoUrl = MutableLiveData<String>()

    init {

    }

    fun destroy() {

    }

    fun btnPageAuthorClick(authorUrl: String) {
        this.authorUrl.value = authorUrl
    }

    fun btnPagePhotoClick(postPhotoUrl: String) {
        this.postPhotoUrl.value = postPhotoUrl
    }

}