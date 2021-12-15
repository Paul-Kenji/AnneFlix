package com.gmail.eamosse.imdb.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Qui sommes nous ?"
    }
    val text: LiveData<String> = _text
}
