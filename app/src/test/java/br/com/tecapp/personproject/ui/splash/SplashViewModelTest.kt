package br.com.tecapp.personproject.ui.splash

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import kotlin.test.assertEquals

class SplashViewModelTest {

    @get:Rule
    var testRule: TestRule = InstantTaskExecutorRule()

    private lateinit var viewModel: SplashViewModel

    @Before
    fun setup() {
        viewModel = SplashViewModel()
    }

    @Test
    fun test_onButtonClick() {
        viewModel.btnGoClick()

        assertEquals(viewModel.openPhotosView.value, Unit)
    }

}