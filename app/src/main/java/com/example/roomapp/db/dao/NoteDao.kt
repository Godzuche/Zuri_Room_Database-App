package com.example.roomapp.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomapp.db.entities.NoteEntity

@Dao
interface NoteDao {
    @Query("SELECT * FROM note")
    fun selectAllNote(): LiveData<List<NoteEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(NoteEntity: NoteEntity)

    @Delete
    fun deleteNote(NoteEntity: NoteEntity)

    @Update
    fun updateNote(NoteEntity: NoteEntity)

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

    @Query("SELECT * FROM note WHERE email = :e_mail AND password = :pass_word")
    suspend fun findCredentials(e_mail: String, pass_word: String): NoteEntity

}