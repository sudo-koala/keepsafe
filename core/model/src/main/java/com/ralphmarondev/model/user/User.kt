package com.ralphmarondev.model.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ralphmarondev.utils.createDate

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fullName: String,
    val username: String,
    val password: String,
    val createDate: String = createDate()
)