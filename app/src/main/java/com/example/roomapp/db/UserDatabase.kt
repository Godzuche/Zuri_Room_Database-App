package com.example.roomapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomapp.db.dao.UserDao
import com.example.roomapp.db.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao() : UserDao
    companion object{
        @Volatile private var instance:UserDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context, UserDatabase::class.java, "user.db").build()
    }
}