package com.example.users.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.users.R
import com.example.users.databinding.FragmentMainBinding
import com.example.users.models.User

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val binding: FragmentMainBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_main, container, false
        )

        // on observe les utilisateurs stockés en base
        viewModel.usersLiveData.observe(viewLifecycleOwner, {
            // TODO : afficher ou actualiser une liste des utilisateurs
        })

        // On ajoute 10 utilisateurs random
        repeat(10) {
            val user = User(name = "UserRandom" + (1..1000).random(), age = (1..99).random())
            viewModel.insertUser(user)
        }

        return binding.root
    }



}