package com.example.roomapp.db

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.roomapp.db.entities.UserEntity
import kotlinx.coroutines.*

class UserRepository(context: Context) {
    private val db = UserDatabase.invoke(context)

    fun getAllUser(): LiveData<List<UserEntity>> = db.userDao().selectAllUser()
    fun insertUser(noteEntity: UserEntity){
        GlobalScope.launch {
            withContext(Dispatchers.IO){
                db.userDao().insertUser(noteEntity)
            }
        }
    }



    suspend fun findCredentials(email:String, pass_word: String): UserEntity =
        withContext(Dispatchers.IO) {
            val deffered = async(Dispatchers.IO) {
                db.userDao().findCredentials(email, pass_word)
            }
            deffered.await()
        }
}