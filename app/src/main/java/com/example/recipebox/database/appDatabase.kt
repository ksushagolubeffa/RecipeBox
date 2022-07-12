package com.example.recipebox.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Recipes::class, Favourite::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}