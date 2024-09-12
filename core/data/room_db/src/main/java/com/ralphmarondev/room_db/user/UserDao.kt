package com.ralphmarondev.room_db.user

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.ralphmarondev.model.user.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
    fun getAllUsers(): Flow<List<User>>

    @Upsert
    suspend fun createNewUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("DELETE FROM User WHERE id=:id")
    suspend fun deleteUser(id: Int)

    @Query("SELECT EXISTS(SELECT 1 FROM User WHERE username=:username AND password=:password)")
    suspend fun userExists(username: String, password: String): Boolean
}