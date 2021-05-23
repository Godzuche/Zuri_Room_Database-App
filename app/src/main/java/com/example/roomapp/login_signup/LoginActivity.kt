
package com.example.roomapp.login_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapp.contact.ContactCategoryActivity
import com.example.roomapp.databinding.ActivityLoginBinding
import com.example.roomapp.db.NoteRepository
import com.example.roomapp.db.entities.NoteEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var noteRepository: NoteRepository
//    private lateinit val foundNoteEntity: NoteEntity
//    private lateinit var result: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Welcome back Godzuche!", Toast.LENGTH_LONG).show() //modify laater
        login()
    }

    private fun login() {
        noteRepository = NoteRepository(this)


        binding.loginButton.setOnClickListener {
            val email = binding.emailEditTextLogin.text
            val password = binding.passwordEditTextLogin.text
            val enteredCredentials = NoteEntity(email.toString(), password.toString())

            GlobalScope.launch(Dispatchers.Main) {
                val foundNoteEntity = noteRepository.findCredentials(email.toString(), password.toString())
                //used this commented lines to verify the type of data found in the database
//                this@LoginActivity.result = foundNoteEntity.toString()
//                Toast.makeText(this@LoginActivity, result, Toast.LENGTH_SHORT).show()

                if(email.isNullOrEmpty() || password.isNullOrEmpty()) {
                    Toast.makeText(this@LoginActivity, "Enter your login credentials", Toast.LENGTH_SHORT).show()
                } else {
                    if (foundNoteEntity == enteredCredentials ){
                        val intent = Intent(this@LoginActivity, ContactCategoryActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this@LoginActivity, "Account does not exist!", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }


}
//                GlobalScope.launch {
//                    withContext(Dispatchers.IO) {
//                        val r = noteRepository.findCredentials(email, pass_word)
//                        launch(Dispatchers.Main) {
//                            noteEntity = r
//                        }
//                    }
//                }
