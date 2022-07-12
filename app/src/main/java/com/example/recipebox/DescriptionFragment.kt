package com.example.recipebox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.recipebox.RecipesRepository.recipes
import com.example.recipebox.database.AppDatabase
import com.example.recipebox.database.Recipes
import com.example.recipebox.databinding.FragmentDescriptionBinding
import java.lang.Exception

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private var _binding: FragmentDescriptionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View {
        _binding = FragmentDescriptionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeDao = context?.let {
            Room.databaseBuilder(it, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
                .recipeDao()
        }

        val recipes: Recipes? = recipeDao?.getRecipeById(ID)
        if (recipes != null) {
            Glide.with(this).load(recipes.url).into(binding.ivCover)
        }
        if (recipes != null) {
            binding.tvName.text = recipes.name
        }
        if (recipes != null) {
            binding.tvDescription.text = recipes.description
        }
        if (recipes != null) {
            binding.tvIngredients.text = recipes.ingredients
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val ARG_ID = "ARG_ID"

        fun createBundle(id: Int) = Bundle().apply {
            putInt(ARG_ID, id)
        }

        private val ID get() = ARG_ID.toInt()
    }
}