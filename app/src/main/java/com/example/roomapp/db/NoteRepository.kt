package com.example.roomapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomapp.db.entities.NoteEntity
import kotlinx.coroutines.*

class NoteRepository(context: Context) {
    private val db = NoteDatabase.invoke(context)

    fun getAllNote(): LiveData<List<NoteEntity>> = db.noteDao().selectAllNote()
    fun insertNote(noteEntity: NoteEntity){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.noteDao().insertNote(noteEntity)
            }
        }
    }



    suspend fun findCredentials(email:String, pass_word: String): NoteEntity =
        withContext(Dispatchers.IO) {
            val deffered = async(Dispatchers.IO) {
                db.noteDao().findCredentials(email, pass_word)
            }
            deffered.await()
        }
}