package com.example.telephone.Domain.Model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")
data class Contact(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    @ColumnInfo(name = "phone")
    val phone : String,
    @ColumnInfo(name = "name")
    val name :String,
    @ColumnInfo(name = "surname")
    val surname : String,
    @ColumnInfo(name = "email")
    val email : String,
)
