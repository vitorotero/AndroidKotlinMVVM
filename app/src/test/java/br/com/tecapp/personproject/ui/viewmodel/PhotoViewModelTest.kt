package br.com.tecapp.personproject.ui.viewmodel

import br.com.tecapp.personproject.shared.model.Photo
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

class PhotoViewModelTest {

    private lateinit var viewModel: PhotoViewModel
    private val photo = Photo(0, "png", "photo_name", "vitor otero", "github.com/vitorotero", "github.com/vitorotero")

    @Before
    fun setup() {
        viewModel = PhotoViewModel(photo)
    }

    @Test
    fun test_propertiesValues() {
        assertEquals(viewModel.fileName, photo.fileName)
        assertEquals(viewModel.author, photo.author)
        assertEquals(viewModel.authorUrl, photo.authorUrl)
        assertEquals(viewModel.postUrl, photo.postUrl)
        assertEquals(viewModel.photoUrl, PhotoViewModel.API_URL_PHOTO + photo.id)
    }

}