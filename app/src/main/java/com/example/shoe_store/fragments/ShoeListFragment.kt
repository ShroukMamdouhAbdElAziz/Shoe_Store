package com.example.shoe_store.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentShoeListBinding
import com.example.shoe_store.databinding.ShoeItemBinding
import com.example.shoe_store.viewmodel.SharedViewModel


class ShoeListFragment : Fragment() {

    lateinit var binding: FragmentShoeListBinding

    private val listviewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_shoe_list, container, false)
        setHasOptionsMenu(true)
        return binding.root

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //id inside menu xml
            R.id.loginFragment -> {
                findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu, menu)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.navigateToShoeDetailsScreenBtn.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeListFragment_to_shoeDetailsScreen)

        )
        listviewModel.listLiveData.observe(viewLifecycleOwner) {
            var shoeList = binding.linearLayout
            it.forEach {
                val itemBinding = ShoeItemBinding.inflate(layoutInflater)
                itemBinding.shoe = it
                shoeList.addView(itemBinding.root)

            }
        }


    }


}