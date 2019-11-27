package com.trecemonos.monkeyapp.ui.send

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SendViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Desarrolladores:"
    }
    val text: LiveData<String> = _text
}