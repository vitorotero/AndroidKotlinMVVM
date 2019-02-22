package br.com.tecapp.personproject.shared.manager

import androidx.databinding.ObservableArrayList
import br.com.tecapp.personproject.shared.model.Photo

interface PhotoManager {

    fun listPhotos() : ObservableArrayList<Photo>

}
