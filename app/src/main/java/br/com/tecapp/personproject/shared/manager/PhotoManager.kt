package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.shared.model.Photo
import io.reactivex.Observable

interface PhotoManager {

    fun listPhotos(): Observable<List<Photo>>

}
