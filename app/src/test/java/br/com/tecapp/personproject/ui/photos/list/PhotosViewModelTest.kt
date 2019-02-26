package br.com.tecapp.personproject.ui.photos.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.shared.model.Photo
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertNull


class PhotosViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var photoManager: PhotoManager
    lateinit var photosViewModel: PhotosViewModel

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        photoManager = mock()
        photosViewModel = PhotosViewModel()
    }

    @Test
    fun test_noDataOnApi_returnsEmptyList() {
        val empty: List<Photo> = emptyList()

        whenever(photoManager.listPhotos())
            .thenReturn(Observable.just(empty))

        photosViewModel.listPhotos()

        val pho = Photo(0, "", "", "", "", "")
        val vm = PhotoViewModel(pho)
        assertEquals(photosViewModel.photosViewModel.value, listOf(vm))

    }

}