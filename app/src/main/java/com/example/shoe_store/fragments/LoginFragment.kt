package com.example.shoe_store.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.shoe_store.R
import com.example.shoe_store.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onBoardingFragment)
        )
        binding.registerButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_onBoardingFragment)
        )
    }


}