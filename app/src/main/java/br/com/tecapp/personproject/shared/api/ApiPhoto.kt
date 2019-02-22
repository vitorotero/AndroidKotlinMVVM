package br.com.tecapp.personproject.shared.api

import androidx.databinding.ObservableArrayList
import br.com.tecapp.personproject.shared.model.Photo
import retrofit2.http.GET

interface ApiPhoto {

    @GET("list")
    fun listPhotos(): ObservableArrayList<Photo>

}