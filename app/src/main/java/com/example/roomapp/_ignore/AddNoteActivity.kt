package com.example.roomapp._ignore

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapp.R
import com.example.roomapp.db.NoteRepository

class AddNoteActivity : AppCompatActivity() {
    private lateinit var titleEditText: EditText
    private lateinit var descriptionEditText: EditText
    private lateinit var addBtn: Button
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        init()

    }

    private fun init() {
        titleEditText = findViewById(R.id.note_title_edittext)
        descriptionEditText = findViewById(R.id.description_edit_text)
        addBtn = findViewById(R.id.addButton)
        noteRepository = NoteRepository(this)

        addBtn.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
//        if (titleEditText.text.isNullOrBlank() || descriptionEditText.text.isNullOrBlank()) {
//            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
//        }else {
//            val note = NoteEntity(title = titleEditText.text.toString(), description = descriptionEditText.text.toString())
//            noteRepository.insertNote(note)
//            finish()
//        }
    }
}