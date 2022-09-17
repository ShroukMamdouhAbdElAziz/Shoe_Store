package com.example.shoe_store.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.shoe_store.models.Shoe
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentShoeDetailsScreenBinding
import com.example.shoe_store.viewmodel.SharedViewModel


class ShoeDetailsScreen : Fragment() {
    private val shoe = Shoe()

    lateinit var binding: FragmentShoeDetailsScreenBinding

    private val viewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater,
                R.layout.fragment_shoe_details_screen,
                container,
                false)
        binding.shoe = shoe

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveBtn.setOnClickListener {
            viewModel.addShoe(shoe)

            findNavController().navigateUp()

        }

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}