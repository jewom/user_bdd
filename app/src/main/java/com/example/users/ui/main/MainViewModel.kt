package com.example.users.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.users.models.User
import com.example.users.repositories.UserLocalRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    val usersLiveData: LiveData<List<User>> = UserLocalRepository.getUsers()

    fun insertUser(user: User){
        viewModelScope.launch {
            UserLocalRepository.insertUser(user)
        }
    }

}