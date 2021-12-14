package com.mmajka.hilt_prakt_retrofit.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mmajka.hilt_prakt_retrofit.data.models.Category
import com.mmajka.hilt_prakt_retrofit.databinding.ItemCategoryBinding

interface CategoryInterface{
    fun onClick(position: Int, category: Category)
    fun onLongClick(position: Int, category: Category)
}
class CategoryAdapter(private val items: List<Category>, private val categoryInterface: CategoryInterface):
    RecyclerView.Adapter<CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CategoryViewHolder(ItemCategoryBinding.inflate(
        LayoutInflater.from(parent.context)))

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(items[position], categoryInterface)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class CategoryViewHolder(val binding: ItemCategoryBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(category: Category, categoryInterface: CategoryInterface){
        binding.category = category

        itemView.setOnClickListener {
            categoryInterface.onClick(adapterPosition, category)
        }

        itemView.setOnLongClickListener{
            categoryInterface.onLongClick(adapterPosition, category)
            return@setOnLongClickListener true
        }
    }
}