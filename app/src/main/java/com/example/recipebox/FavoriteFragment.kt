package com.example.recipebox

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.bumptech.glide.Glide
import com.example.recipebox.database.AppDatabase
import com.example.recipebox.database.Favourite
import com.example.recipebox.database.Recipes
import com.example.recipebox.databinding.FragmentFavoriteBinding


class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    private var adapter: RecipesAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentFavoriteBinding.bind(view)

        val recipeDao = context?.let {
            Room.databaseBuilder(it, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
                .recipeDao()
        }

        if (recipeDao != null) {
            adapter = RecipesAdapter(recipeDao.getAllFavourite().map { Favourite -> recipeDao.getRecipeById(Favourite.id) }, Glide.with(this)) { id ->
                findNavController().navigate(
                    R.id.action_favoriteFragment_to_descriptionFragment,
                    DescriptionFragment.createBundle(id)
                )
            }
        }

        binding.rvFavorite.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}