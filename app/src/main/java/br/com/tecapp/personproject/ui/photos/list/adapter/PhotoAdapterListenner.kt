package br.com.tecapp.personproject.ui.photos.list.adapter

import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel

interface PhotoAdapterListenner {

    fun openUrlAuthor(url: String)
    fun openDetail(photoViewModel: PhotoViewModel)

}