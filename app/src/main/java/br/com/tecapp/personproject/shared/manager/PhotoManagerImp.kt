package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import io.reactivex.Observable

class PhotoManagerImp(private var apiPhoto: ApiPhoto) : PhotoManager {

    override fun listPhotos(): Observable<List<PhotoViewModel>> {
        return apiPhoto.listPhotos()
            .map { photos ->
                photos.map { PhotoViewModel(it) }
            }
    }
    
}
