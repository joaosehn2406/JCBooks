package com.jceco.jcbooks.entity

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    var favorite: Boolean,
    val genre: String

)