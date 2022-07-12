package com.example.recipebox

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.recipebox.database.AppDatabase
import com.example.recipebox.databinding.FragmentRecipesBinding

class RecipesFragment : Fragment(R.layout.fragment_recipes) {

    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private var adapter: RecipesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRecipesBinding.bind(view)

        val recipeDao = context?.let {
            Room.databaseBuilder(it, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
                .recipeDao()
        }

        if (recipeDao != null) {
            adapter = RecipesAdapter(RecipesRepository.recipes, Glide.with(this)) { id ->
                findNavController().navigate(
                    R.id.action_recipesFragment_to_descriptionFragment,
                    DescriptionFragment.createBundle(id)
                )
            }
        }

        binding.rvSeries.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}