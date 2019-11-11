package com.trecemonos.monkeyapp.ui.gallery

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Galería:"
    }
    val text: LiveData<String> = _text
}