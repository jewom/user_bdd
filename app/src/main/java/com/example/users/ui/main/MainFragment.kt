package com.example.users.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.users.R
import com.example.users.models.User

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.usersLiveData.observe(viewLifecycleOwner, { users ->
            users.forEach { Log.d("TEST_LOG", it.toString()) }
        })

        repeat(10) {
            val user = User(name = "UserRandom" + (1..1000).random(), age = (1..99).random())
            viewModel.insertUser(user)
        }

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

}