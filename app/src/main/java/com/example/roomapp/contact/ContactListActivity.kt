package com.example.roomapp.contact

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapp.CategoryAdapter
import com.example.roomapp.ContactAdapter
import com.example.roomapp.R
import com.example.roomapp.databinding.ActivityContactListBinding

class ContactListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactListBinding
    private var icon = 0
    private var categoryName: String? = ""
    private val adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        icon = intent.getIntExtra(CategoryAdapter.ICON_EXTRAS, 0)
        categoryName = intent.getStringExtra(CategoryAdapter.CATEGORY_NAME_EXTRAS)
        setupData(binding)
    }


    private fun setupData(binding: ActivityContactListBinding) {
        title = categoryName
        binding.contactRv.adapter = adapter
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.add_contact_dialog, null)
        builder.setView(view)

        val name = view.findViewById<TextView>(R.id.nameEt)
        val no = view.findViewById<TextView>(R.id.numberEt)
        val saveBtn = view.findViewById<Button>(R.id.saveBt)
        no.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                saveBtn.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

        val alertDialog = builder.create()

        binding.addFAB.setOnClickListener {
            alertDialog.show()
        }

        saveBtn.setOnClickListener {
            val contact = Contact(name.text.toString(), no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()
        }
    }
}