package br.com.tecapp.personproject.ui.photos.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import br.com.tecapp.personproject.rule.TestCoroutineRule
import br.com.tecapp.personproject.shared.api.ApiPhoto
import br.com.tecapp.personproject.shared.manager.PhotoManager
import br.com.tecapp.personproject.shared.model.Photo
import br.com.tecapp.personproject.ui.viewmodel.PhotoViewModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.mockito.Mock
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull

@ExperimentalCoroutinesApi
class PhotosViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var apiPhoto: ApiPhoto
    @Mock
    lateinit var photoManager: PhotoManager
    private lateinit var viewModel: PhotosViewModel

    @Before
    fun setup() {
//        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
//        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }

        photoManager = mock()
        apiPhoto = mock()
        viewModel = PhotosViewModel(photoManager)
    }

    @After
    fun after() {
        viewModel.destroy()
    }

    @Test
    fun test_noDataOnApi_returnsEmptyList() = testCoroutineRule.runBlockingTest {
        val empty: List<PhotoViewModel> = emptyList()

        whenever(photoManager.listPhotos()).thenReturn(async { empty })

        viewModel.listPhotos()

        assertEquals(viewModel.photos.value, empty)
    }

    @Test
    fun test_DataOnApi_returnsValues() = testCoroutineRule.runBlockingTest {
        val result = listOf(PhotoViewModel(Photo(0, "", "", "", "", "")))

        whenever(photoManager.listPhotos()).thenReturn(async { result })

        viewModel.listPhotos()

        assertNotNull(viewModel.photos.value)
    }

    @Test
    fun test_DataOnApi_returnsError() = testCoroutineRule.runBlockingTest {
        val result = Throwable()

        whenever(photoManager.listPhotos()).thenThrow(result)

        viewModel.listPhotos()

        assertNull(viewModel.photos.value)
        assertNotNull(viewModel.error.value)
    }

}