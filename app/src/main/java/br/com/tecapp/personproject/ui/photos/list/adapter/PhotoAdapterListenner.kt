package br.com.tecapp.personproject.ui.photos.list.adapter

import android.view.View
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel

interface PhotoAdapterListenner {

    fun openUrlAuthor(url: String)
    fun openDetail(imageView: View, textView: View, photoViewModel: PhotoViewModel)

}