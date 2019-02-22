package br.com.tecapp.personproject.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    val openPhotosView = MutableLiveData<Unit>()

    fun btnGoClick() {
        openPhotosView.value = Unit
    }

}