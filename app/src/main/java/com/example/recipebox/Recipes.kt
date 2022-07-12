package com.example.recipebox

data class Recipes(
    val id: Int,
    val name: String,
    val description: String,
    val ingredients: String,
    val url: String,
)