package com.jceco.jcbooks.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jceco.jcbooks.entity.Book
import com.jceco.jcbooks.repository.BookRepository

class HomeViewModel : ViewModel() {

    private val _books = MutableLiveData<List<Book>>()
    val books: LiveData<List<Book>> = _books

    private val respository = BookRepository.getInstance()

    fun getAllBooks() {
        _books.value = respository.getAllBooks()
    }
}