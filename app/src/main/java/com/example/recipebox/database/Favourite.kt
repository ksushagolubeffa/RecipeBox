package com.example.recipebox.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourite_table")
data class Favourite (
    @PrimaryKey(autoGenerate = false) var id: Int
        )