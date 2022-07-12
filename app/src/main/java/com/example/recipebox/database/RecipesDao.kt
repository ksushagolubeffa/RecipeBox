package com.example.recipebox.database

import androidx.room.*

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes_table")
    fun getAllRecipes(): List<Recipes>

    @Query("SELECT * FROM recipes_table WHERE id LIKE :inputId")
    fun getRecipeById(inputId: Int): Recipes

    @Query("SELECT * FROM favourite_table")
    fun getAllFavourite(): List<Favourite>

    @Query("SELECT * FROM favourite_table WHERE id LIKE :inputId")
    fun getFavouriteByID(inputId: Int): Favourite

    @Insert
    fun insertRecipe(recipe: Recipes)

    @Insert
    fun insertFavourite(favourite: Favourite)

    @Delete
    fun deleteRecipe(recipe: Recipes)

    @Delete
    fun deleteFavourite(favourite: Favourite)

    @Query("DELETE FROM recipes_table")
    fun deleteAllRecipes()

    @Query("DELETE FROM favourite_table")
    fun deleteAllFavourites()
}