package com.jceco.jcbooks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jceco.jcbooks.entity.Book
import com.jceco.jcbooks.repository.BookRepository

class DetailsViewModel : ViewModel() {

    private val repository: BookRepository = BookRepository()

    private val _book = MutableLiveData<Book>()
    val book: LiveData<Book> = _book

    fun getBookById(id: Int) {
        _book.value = repository.getBookById(id)
    }
}