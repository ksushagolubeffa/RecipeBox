package com.example.recipebox

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.recipebox.database.AppDatabase
import com.example.recipebox.database.Recipes
import com.example.recipebox.databinding.FragmentAddBinding
import com.google.android.material.snackbar.Snackbar

class AddFragment: Fragment(R.layout.fragment_add) {

    private var title: String = ""

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAddBinding.bind(view)
        binding.bottomAdd.setOnClickListener{
            with(binding) {
                addToBase(editText.text.toString(),editText2.text.toString(),
                    editText3.text.toString(),editText4.text.toString())
            }
            Snackbar.make(view, "Рецепт успешно сохранен!", Snackbar.LENGTH_LONG).apply { setAnchorView(R.id.bottom_navigation) }.show()
        }
    }



    private fun addToBase(
        nameGet: String,
        descriptionGet: String,
        ingredientsGet: String,
        urlGet: String
    ) {
        val newRecipes = Recipes(
            name = nameGet,
            description = descriptionGet,
            ingredients = ingredientsGet,
            url = urlGet
        )
        context?.let {
            Room.databaseBuilder(it, AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
                .recipeDao()
        }?.insertRecipe(newRecipes)
    }
}