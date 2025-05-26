package com.jceco.jcbooks.repository

import com.jceco.jcbooks.entity.Book

class BookRepository {

    private val books = mutableListOf<Book>()

    init {
        books.addAll(getInitialBooks())
    }

    private fun getInitialBooks(): List<Book> {
        return listOf(
            Book(1, "To Kill a Mockingbird", "Harper Lee", true, "Ficção"),
            Book(2, "Dom Casmurro", "Machado de Assis", false, "Romance"),
            Book(3, "O Hobbit", "J.R.R. Tolkien", true, "Fantasia"),
            Book(4, "Cem Anos de Solidão", "Gabriel García Márquez", false, "Romance"),
            Book(5, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", false, "Fantasia"),
            Book(6, "Crime e Castigo", "Fiódor Dostoiévski", false, "Ficção policial"),
            Book(7, "Frankenstein", "Mary Shelley", false, "Terror"),
            Book(8, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", false, "Fantasia"),
            Book(9, "Neuromancer", "William Gibson", false, "Cyberpunk"),
            Book(10, "Senhor dos Anéis", "J.R.R. Tolkien", false, "Fantasia"),
            Book(11, "Drácula", "Bram Stoker", false, "Terror"),
            Book(12, "Orgulho e Preconceito", "Jane Austen", false, "Romance"),
            Book(13, "Harry Potter e a Câmara Secreta", "J.K. Rowling", false, "Fantasia"),
            Book(14, "As Crônicas de Nárnia", "C.S. Lewis", false, "Fantasia"),
            Book(15, "O Código Da Vinci", "Dan Brown", false, "Mistério"),
            Book(16, "It: A Coisa", "Stephen King", false, "Terror"),
            Book(17, "Moby Dick", "Herman Melville", true, "Aventura"),
            Book(18, "O Nome do Vento", "Patrick Rothfuss", true, "Fantasia"),
            Book(19, "O Conde de Monte Cristo", "Alexandre Dumas", true, "Aventura"),
            Book(20, "Os Miseráveis", "Victor Hugo", false, "Romance")
        )
    }

    fun getAllBooks(): List<Book> {
        return books;
    }

    fun getFavoriteBooks(): List<Book> {
        return books.filter { it.favorite }
    }

    fun getBookById(id: Int): Book? {
        return books.find { it.id == id }
    }

    fun deleteBook(id: Int): Boolean {
        return books.removeIf { it.id == id }
    }

    fun toggleFavoriteStatus(id: Int) {
        val bookSearched = getBookById(id)
        if (bookSearched != null) {
            bookSearched.favorite = !bookSearched.favorite
        }
    }
}