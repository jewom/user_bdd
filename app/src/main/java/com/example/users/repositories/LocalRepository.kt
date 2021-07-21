package com.example.users.repositories

import com.example.users.database.AppDatabase
import com.example.users.models.User

object UserLocalRepository {

    fun getUsers() = AppDatabase.instance.userDao().getAllUsers()

    suspend fun insertUser(user: User) = AppDatabase.instance.userDao().insertUser(user)

}



