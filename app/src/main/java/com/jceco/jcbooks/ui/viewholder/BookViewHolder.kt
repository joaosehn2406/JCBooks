package com.jceco.jcbooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.jceco.jcbooks.databinding.ItemBookBinding
import com.jceco.jcbooks.entity.Book

class BookViewHolder(private val item: ItemBookBinding) : RecyclerView.ViewHolder(item.root) {

    fun bind(book: Book) {
        item.textviewTitle.text = book.title
        item.textviewGenre.text = book.genre
        item.textviewAuthor.text = book.author
    }
}