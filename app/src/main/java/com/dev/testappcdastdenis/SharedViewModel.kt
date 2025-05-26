package com.dev.testappcdastdenis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _userText = MutableLiveData<String>()
    val userText: LiveData<String> = _userText

    fun setUserText(text: String) {
        _userText.value = text
    }
}
