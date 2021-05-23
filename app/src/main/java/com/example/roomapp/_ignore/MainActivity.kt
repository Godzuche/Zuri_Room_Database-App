package com.example.roomapp._ignore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.R
import com.example.roomapp.adapter.NoteAdapter
import com.example.roomapp.db.NoteRepository
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var recyclerView: RecyclerView
    private lateinit var addNoteBtn: FloatingActionButton
    private lateinit var noteRepository: NoteRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        init()
//    }
//
//    private fun init () {
//        noteAdapter = NoteAdapter()
//        linearLayoutManager = LinearLayoutManager(this)
//
//        recyclerView = findViewById(R.id.recyclerView)
//
//        addNoteBtn = findViewById(R.id.floatingActionButton)
//
//        recyclerView.adapter = noteAdapter
//
//        recyclerView.layoutManager = linearLayoutManager
//
//        noteRepository = NoteRepository(this)
//
//
////        insertDataIntoDb() //inserting manually
//        addNoteBtn.setOnClickListener {
//            openAddNote()
//        }
//    }
//
//    override fun onResume() {
//        super.onResume()
//        noteRepository.getAllNote().observe(this, { notes ->
//            noteAdapter.submitList(notes)
//            noteAdapter.notifyDataSetChanged()
//        })
//    }
//
//    private fun openAddNote(){
//        val intent = Intent(this, SignUpActivity::class.java)
//        startActivity(intent)
//    }
//
////    private fun insertDataIntoDb(){
////        val noteEntity = NoteEntity(title = "Hey", description = "Hi, how are you?")
////        noteRepository.insertNote(noteEntity)
////    }
}}