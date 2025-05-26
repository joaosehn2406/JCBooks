package com.jceco.jcbooks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jceco.jcbooks.repository.BookRepository

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val respository = BookRepository()

    fun getAllBooks() {
        respository.getAllBooks()
    }
}