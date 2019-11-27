package com.trecemonos.monkeyapp.ui.share

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ShareViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "COMPARTIR"
    }
    val text: LiveData<String> = _text
}