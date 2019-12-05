package br.com.tecapp.personproject.shared.api

import br.com.tecapp.personproject.shared.model.Photo
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiPhoto {

    @GET("list")
    fun listPhotos(): Deferred<List<Photo>>

}