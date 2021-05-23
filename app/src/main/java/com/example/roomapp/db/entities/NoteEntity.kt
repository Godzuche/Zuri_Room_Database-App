package com.example.roomapp.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(
//    @PrimaryKey(autoGenerate = true)
//    val id: Int = 0,
    @PrimaryKey(autoGenerate = false)
    var email: String,
    @ColumnInfo(name = "password")
    var password: String
)
