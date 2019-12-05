package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext

class PhotoManagerImp(private var apiPhoto: ApiPhoto) : PhotoManager {

    override suspend fun listPhotos() = withContext(IO) {
        async {
            apiPhoto.listPhotos()
                .await()
                .map { PhotoViewModel(it) }
        }
    }

}
