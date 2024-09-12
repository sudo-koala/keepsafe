package com.ralphmarondev.room_db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ralphmarondev.model.user.User
import com.ralphmarondev.room_db.user.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val NAME = "keepsafe"
    }

    abstract fun dao(): UserDao
}