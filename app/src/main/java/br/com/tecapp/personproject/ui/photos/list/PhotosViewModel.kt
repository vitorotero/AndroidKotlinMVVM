package br.com.tecapp.personproject.ui.photos.list

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PhotosViewModel(private val photoManager: PhotoManager) : ViewModel(), CoroutineScope {

    override val coroutineContext = Main
    private var jobs = ArrayList<Job>()

    val photos: MutableLiveData<List<PhotoViewModel>> = MutableLiveData()
    val error: MutableLiveData<String> = MutableLiveData()

    override fun onCleared() {
        super.onCleared()
        jobs.forEach { if (!it.isCancelled) it.cancel() }
    }

    fun destroy() {
        super.onCleared()
    }

    fun listPhotos() {
        jobs.add(launch {
            try {
                photos.value = photoManager.listPhotos().await()
            } catch (t: Throwable) {
                photos.value = emptyList()
                error.value = "Ocorreu um erro"
            }
        })
    }

}