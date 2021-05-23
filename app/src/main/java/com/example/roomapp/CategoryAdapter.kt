package com.example.roomapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.roomapp.contact.Category
import com.example.roomapp.contact.ContactListActivity

class CategoryAdapter(private var ctx: Context) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private val categories = mutableListOf<Category>()

    fun setupCategories(categories: List<Category>) {
        this.categories.addAll(categories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
                LayoutInflater.from(ctx).inflate(R.layout.contact_category_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bindItem(category)
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    inner class CategoryViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

            fun bindItem(category: Category) {
                val iconImage = itemView.findViewById<ImageView>(R.id.iconIv)
                iconImage.setImageResource(category.icon)
                val iconText = itemView.findViewById<TextView>(R.id.icon_Tv)
                iconText.text = category.category_name

                itemView.setOnClickListener {
                    val titleq = category.category_name
                    Toast.makeText(ctx, titleq, Toast.LENGTH_LONG).show()
                    val intent = Intent(ctx, ContactListActivity::class.java)

                    intent.putExtra(ICON_EXTRAS, category.icon)
                    intent.putExtra(CATEGORY_NAME_EXTRAS, category.category_name)

                    ctx.startActivity(intent)
                }
            }
        }

    companion object{
        const val ICON_EXTRAS = "icon_extras"
        const val CATEGORY_NAME_EXTRAS = "category_name_extras"
    }


}