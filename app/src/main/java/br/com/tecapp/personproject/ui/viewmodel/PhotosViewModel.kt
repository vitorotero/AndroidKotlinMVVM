package br.com.tecapp.personproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.shared.manager.PhotoManagerImp

class PhotosViewModel : ViewModel() {

    private val photoManager: PhotoManager = PhotoManagerImp()
    var photoViewModel = MutableLiveData<List<PhotoViewModel>>()

    fun listPhotos() {
        
    }

}