package com.reto.retoandroid.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.reto.retoandroid.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Usar Safe Args para obtener los datos
        val args = DetailFragmentArgs.fromBundle(requireArguments())

        binding.detailTitle.text = args.title
        binding.detailPrice.text = "$${args.price}"
        binding.detailCategory.text = args.category
        binding.detailDescription.text = args.description
        Picasso.get().load(args.image).into(binding.detailImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
