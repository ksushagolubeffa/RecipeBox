package com.example.recipebox

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.recipebox.databinding.ItemRecipesBinding

class RecipesAdapter(
    private val list: List<Recipes>,
    private val glide: RequestManager,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<RecipesHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesHolder = RecipesHolder(
        ItemRecipesBinding.inflate(LayoutInflater.from(parent.context), parent, false),
        glide,
        onItemClick
    )

    override fun onBindViewHolder(holder: RecipesHolder, position: Int) = holder.onBind(list[position])

    override fun getItemCount(): Int = list.size
}