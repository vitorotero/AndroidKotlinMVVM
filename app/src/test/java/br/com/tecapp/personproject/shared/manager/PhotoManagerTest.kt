package br.com.tecapp.personproject.shared.manager

import br.com.tecapp.personproject.shared.api.ApiPhoto
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`

class PhotoManagerTest {

    @Mock
    lateinit var apiPhoto: ApiPhoto

    lateinit var photoManager: PhotoManager

    @Before
    fun setup() {
        photoManager = PhotoManagerImp(apiPhoto)
    }

    @Test
    fun test_noDataOnApi_returnsEmptyList() {
        `when`(apiPhoto.listPhotos())
            .thenReturn(Observable.just(emptyList()))


    }

}