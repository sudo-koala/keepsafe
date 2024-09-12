package com.ralphmarondev.application

import android.app.Application
import androidx.room.Room
import com.ralphmarondev.room_db.AppDatabase

class KeepSafe : Application() {
    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database= Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            AppDatabase.NAME
        ).build()
    }
}