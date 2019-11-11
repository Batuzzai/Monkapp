package com.trecemonos.monkeyapp.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "MonkeyAPP"
    }
    val text: LiveData<String> = _text
}