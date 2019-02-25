package br.com.tecapp.personproject.shared.api

import br.com.tecapp.personproject.shared.model.Photo
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiPhoto {

    @GET("list")
    fun listPhotos(): Observable<List<Photo>>

}