package com.jceco.jcbooks.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.jceco.jcbooks.R
import com.jceco.jcbooks.databinding.ItemBookBinding
import com.jceco.jcbooks.entity.Book
import com.jceco.jcbooks.ui.listener.BookListener

class BookViewHolder(private val item: ItemBookBinding, private val listener: BookListener) :
    RecyclerView.ViewHolder(item.root) {

    fun bind(book: Book) {
        item.textviewTitle.text = book.title
        item.textviewGenre.text = book.genre
        item.textviewAuthor.text = book.author

        item.textviewTitle.setOnClickListener(this)

        defineBackground(book.genre)

        updateFavoriteIcon(book.favorite)
    }

    private fun defineBackground(genre: String) = when (genre) {
        "Terror" -> {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_red)
        }
        "Fantasia" -> {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_fantasy)
        }
        else -> {
            item.textviewGenre.setBackgroundResource(R.drawable.rounded_label_teal)
        }
    }

    private fun updateFavoriteIcon(favorite: Boolean) = when (favorite){
        true -> item.imageviewFavorite.setImageResource(R.drawable.ic_favorite)
        false -> item.imageviewFavorite.setImageResource(R.drawable.ic_favorite_empty)
    }


}