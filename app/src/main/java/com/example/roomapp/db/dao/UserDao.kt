package com.example.roomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomapp.db.entities.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun selectAllUser(): LiveData<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(UserEntity: UserEntity)

    @Delete
    fun deleteUser(UserEntity: UserEntity)

    @Update
    fun updateUser(UserEntity: UserEntity)

//    @Query("SELECT * from note WHERE id = :key")
//    fun findUserById(key: Int): NoteEntity?
//
//    @Query("DELETE FROM note")
//    fun clear()
//
//    @Query("SELECT * FROM note ORDER BY id DESC LIMIT 1")
//    fun getRecentNote():NoteEntity?
//
//    @Query("SELECT * FROM note ORDER BY id DESC")
//    fun getAllNote(): LiveData<List<NoteEntity>>

    @Query("SELECT * FROM user WHERE email = :e_mail AND password = :pass_word")
    suspend fun findCredentials(e_mail: String, pass_word: String): UserEntity

}