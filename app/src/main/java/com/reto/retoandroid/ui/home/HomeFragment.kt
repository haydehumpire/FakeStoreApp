package com.reto.retoandroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.reto.retoandroid.databinding.FragmentHomeBinding
import com.reto.retoandroid.ui.home.adapter.ProductAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ProductViewModel by viewModels()
    private lateinit var adapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Adapter con navegación
        adapter = ProductAdapter { product ->
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(
                title = product.title,
                price = product.price.toFloat(),
                image = product.image,
                description = product.description,
                category = product.category
            )
            findNavController().navigate(action)
        }

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        // Observa productos
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.products.collect { productList ->
                adapter.submitList(productList)
            }
        }

        // Recarga manual
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.refreshProducts()
            binding.swipeRefresh.isRefreshing = false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
