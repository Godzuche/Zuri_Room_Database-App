package com.example.roomapp.login_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapp.R
import com.example.roomapp.db.NoteRepository
import com.example.roomapp.db.entities.NoteEntity

class SignUpActivity : AppCompatActivity() {
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var signUpButton: Button
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()

    }

    private fun init() {
        emailEditText = findViewById(R.id.email_edit_text)
        signUpButton = findViewById(R.id.sign_up_button)
        passwordEditText = findViewById(R.id.password_edit_text)
        noteRepository = NoteRepository(this)

        signUpButton.setOnClickListener {
            saveNote()
        }
    }

    private fun saveNote() {
        if (emailEditText.text.isNullOrBlank() || passwordEditText.text.isNullOrBlank()) {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
        }else {
            val note = NoteEntity(email = emailEditText.text.toString(), password = passwordEditText.text.toString())
            noteRepository.insertNote(note)
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}