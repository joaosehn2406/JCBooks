package com.jceco.jcbooks.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jceco.jcbooks.R
import com.jceco.jcbooks.databinding.FragmentFavoriteBinding
import com.jceco.jcbooks.helper.BookConstants
import com.jceco.jcbooks.ui.adapter.BookAdapter
import com.jceco.jcbooks.ui.listener.BookListener
import com.jceco.jcbooks.viewmodels.FavoriteViewModel

class FavoriteFragment : Fragment() {

    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private val adapter: BookAdapter = BookAdapter()

    private val viewModel: FavoriteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)

        binding.recyclerviewBooksFavorite.layoutManager = LinearLayoutManager(context)
        binding.recyclerviewBooksFavorite.adapter = adapter

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun attachListener() {
        adapter.attachListener(object : BookListener {
            override fun onClick(id: Int) {

                val bundle = Bundle()
                bundle.putInt(BookConstants.KEY.BOOK_ID, id)

                findNavController().navigate(R.id.navigation_details, bundle)
            }

            override fun onFavoriteClick(id: Int) {
                viewModel.favorite(id)
                viewModel.getFavoriteBooks()
            }
        })
    }

    private fun setObservers() {
        viewModel.books.observe(viewLifecycleOwner) {
            adapter.updateBooks(it)
        }
    }
}