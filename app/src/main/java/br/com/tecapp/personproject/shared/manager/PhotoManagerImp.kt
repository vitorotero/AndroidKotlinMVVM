package br.com.tecapp.personproject.shared.manager

import androidx.databinding.ObservableArrayList
import br.com.tecapp.personproject.shared.api.Api
import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.shared.model.Photo

class PhotoManagerImp : Api(), PhotoManager {

    private val apiPhoto: ApiPhoto = retrofit.create(ApiPhoto::class.java)

    init {
    }

    override fun listPhotos(): ObservableArrayList<Photo> {
        return apiPhoto.listPhotos()
    }

}