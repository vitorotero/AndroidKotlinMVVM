package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.shared.api.Api
import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.shared.model.Photo
import io.reactivex.Observable

class PhotoManagerImp : Api(), PhotoManager {

    private val apiPhoto: ApiPhoto = retrofit.create(ApiPhoto::class.java)

    init {
    }

    override fun listPhotos(): Observable<List<Photo>> {
        return apiPhoto.listPhotos()
    }

}