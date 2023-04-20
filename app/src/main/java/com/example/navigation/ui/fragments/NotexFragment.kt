package com.example.navigation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation.R
import com.example.navigation.databinding.FragmentHomeBinding
import com.example.navigation.databinding.FragmentNotexBinding

class NotexFragment : Fragment() {

    private lateinit var binding: FragmentNotexBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View  {
        binding = FragmentNotexBinding.inflate(inflater, container, false)
        return binding.root
    }

}