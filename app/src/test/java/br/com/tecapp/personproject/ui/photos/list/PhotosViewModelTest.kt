package br.com.tecapp.personproject.ui.photos.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.shared.model.Photo
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import kotlin.test.*

class PhotosViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var apiPhoto: ApiPhoto
    @Mock
    lateinit var photoManager: PhotoManager
    private lateinit var viewModel: PhotosViewModel

    @Before
    fun setup() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }

        photoManager = mock()
        apiPhoto = mock()
        viewModel = PhotosViewModel(photoManager)
    }

    @Test
    fun test_noDataOnApi_returnsEmptyList() {
        val empty: List<PhotoViewModel> = emptyList()

        whenever(photoManager.listPhotos()).thenReturn(Observable.just(empty))

        viewModel.listPhotos()

        assertEquals(viewModel.photos.value, empty)
    }

    @Test
    fun test_DataOnApi_returnsValues() {
        val result = Observable.just(listOf(PhotoViewModel(Photo(0, "", "", "", "", ""))))

        whenever(photoManager.listPhotos()).thenReturn(result)

        viewModel.listPhotos()

        assertNotNull(viewModel.photos.value)
    }

    @Test
    fun test_DataOnApi_returnsError() {
        val result = NullPointerException()

        whenever(photoManager.listPhotos()).thenReturn(Observable.error(result))

        viewModel.listPhotos()

        assertNull(viewModel.photos.value)
        assertNotNull(viewModel.error.value)
    }

}