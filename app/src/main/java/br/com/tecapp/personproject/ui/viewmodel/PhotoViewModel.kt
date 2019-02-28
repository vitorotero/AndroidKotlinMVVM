package br.com.tecapp.personproject.ui.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import br.com.tecapp.personproject.shared.model.Photo
import java.io.Serializable


class PhotoViewModel(private val photo: Photo) : BaseObservable(), Serializable {

    companion object {
        const val API_URL_PHOTO = "https://picsum.photos/1920/1080?image="
    }

    val fileName: String
        @Bindable get() {
            return photo.fileName
        }

    val author: String
        @Bindable get() {
            return photo.author
        }

    val authorUrl: String
        @Bindable get() {
            return photo.authorUrl
        }

    val postUrl: String
        @Bindable get() {
            return photo.postUrl
        }

    val photoUrl: String
        @Bindable get() {
            return API_URL_PHOTO + photo.id
        }
}