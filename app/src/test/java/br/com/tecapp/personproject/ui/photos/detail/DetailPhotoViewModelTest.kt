package br.com.tecapp.personproject.ui.photos.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.tecapp.personproject.shared.model.Photo
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertEquals

class DetailPhotoViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: DetailPhotoViewModel
    private val photoViewModel =
        PhotoViewModel(Photo(0, "png", "photo_name", "vitor otero", "github.com/vitorotero", "github.com/vitorotero"))

    @Before
    fun setup() {
        viewModel = DetailPhotoViewModel(photoViewModel)
    }

    @Test
    fun test_onClickAuthorUrl() {
        viewModel.btnPageAuthorClick(photoViewModel.authorUrl)

        assertEquals(viewModel.authorUrl.value, photoViewModel.authorUrl)
    }

    @Test
    fun test_onClickPostUrl() {
        viewModel.btnPageAuthorClick(photoViewModel.postUrl)

        assertEquals(viewModel.authorUrl.value, photoViewModel.postUrl)
    }

}