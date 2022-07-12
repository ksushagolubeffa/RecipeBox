package com.example.recipebox.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recipes_table")
data class Recipes(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var name: String,
    var description: String,
    var ingredients: String,
    var url: String,
)