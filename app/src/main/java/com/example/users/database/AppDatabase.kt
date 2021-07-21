package com.example.users.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.users.App
import com.example.users.models.User

const val DATABASE_NAME = "MY_DATABASE"

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        val instance: AppDatabase by lazy {
            Room.databaseBuilder(
                App.appContext,
                AppDatabase::class.java,
                DATABASE_NAME
            ).build()
        }

    }

}