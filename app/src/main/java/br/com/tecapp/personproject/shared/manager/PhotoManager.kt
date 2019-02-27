package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import io.reactivex.Observable

interface PhotoManager {

    fun listPhotos(): Observable<List<PhotoViewModel>>

}
