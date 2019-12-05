package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import kotlinx.coroutines.Deferred

interface PhotoManager {

    suspend fun listPhotos(): Deferred<List<PhotoViewModel>>

}
