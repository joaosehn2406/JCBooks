package com.jceco.jcbooks.ui

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.jceco.jcbooks.R
import com.jceco.jcbooks.databinding.FragmentDetailsBinding
import com.jceco.jcbooks.databinding.FragmentHomeBinding
import com.jceco.jcbooks.helper.BookConstants
import com.jceco.jcbooks.viewmodels.DetailsViewModel

class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DetailsViewModel by viewModels()

    private var bookId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, b: Bundle?): View {
        _binding = FragmentDetailsBinding.inflate(inflater, container, false)

        setListeners()
        setObservers()

        val bookId = arguments?.getInt(BookConstants.KEY.BOOK_ID) ?: 0
        viewModel.getBookById(bookId)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setObservers() {
        viewModel.book.observe(viewLifecycleOwner) {
            binding.textviewTitle.text = it.title
            binding.textviewAuthor.text = it.author
            binding.textviewGenre.text = it.genre
            binding.checkboxFavorito.isChecked = it.favorite

            defineBackground(it.genre)

            viewModel.bookRemoval.observe(viewLifecycleOwner) {
                if (it) {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.msg_removed_successfully),
                        Toast.LENGTH_LONG
                    ).show()

                    requireActivity().supportFragmentManager.popBackStack()
                }
            }
        }
    }

    private fun setListeners() {
        binding.imageviewBack.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.buttonRemove.setOnClickListener { handleRemove() }

        binding.checkboxFavorito.setOnClickListener { handleFavorite() }
    }

    private fun handleFavorite() {
        viewModel.favorite(bookId)

    }

    private fun handleRemove() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setMessage("Tem certeza que deseja excluir esse item?")
            .setPositiveButton("SIM") { dialog, which ->
                viewModel.deleteBook(bookId)
            }
            .setNegativeButton("NÃO") { dialog, which ->
                dialog.dismiss()
            }
        builder.create().show()
    }


    private fun defineBackground(genre: String) = when (genre) {
        "Terror" -> {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_red)
        }

        "Fantasia" -> {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_fantasy)
        }

        else -> {
            binding.textviewGenreValue.setBackgroundResource(R.drawable.rounded_label_teal)
        }
    }
}