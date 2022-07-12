package com.example.recipebox

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.recipebox.databinding.ItemRecipesBinding

class RecipesHolder(
    private val binding: ItemRecipesBinding,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(recipes: Recipes) {
        with(binding) {
            tvName.text = recipes.name

            glide.load(recipes.url).into(ivCover)

            root.setOnClickListener {
                onItemClick(recipes.id)
            }
        }
    }
}