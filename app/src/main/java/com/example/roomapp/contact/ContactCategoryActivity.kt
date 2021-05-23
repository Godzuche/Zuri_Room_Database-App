package com.example.roomapp.contact

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.roomapp.CategoryAdapter
import com.example.roomapp.R
import com.example.roomapp.databinding.ActivityContactCategoryBinding

class ContactCategoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactCategoryBinding

    private var adapter = CategoryAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupCategory()
    }

    private fun setupCategory() {
        binding.categoryRv.adapter = adapter
//        binding.categoryRv.layoutManager = GridLayoutManager(this, 2)
        var category = Category(R.drawable.ic_baseline_family_restroom_24, "Family")
        var categories = mutableListOf(category)
        adapter.setupCategories(categories)

        category = Category(R.drawable.ic_baseline_school_24, "Tutors")
        categories = mutableListOf(category)
        adapter.setupCategories(categories)

        category = Category(R.drawable.ic_baseline_work_24, "Work")
        categories = mutableListOf(category)
        adapter.setupCategories(categories)

        category = Category(R.drawable.ic_baseline_people_24, "Colleagues")
        categories = mutableListOf(category)
        adapter.setupCategories(categories)

        category = Category(R.drawable.ic_baseline_block_24, "Blocked")
        categories = mutableListOf(category)
        adapter.setupCategories(categories)
    }
}