package com.example.telephone.Domain.Model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.util.Date

data class History(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    var id : String,
    @ColumnInfo(name = "contact")
    var contact : Contact,
    @ColumnInfo(name ="date")
    var date : Date,
    @ColumnInfo(name = "statut")
    var statut : Int,
    @ColumnInfo(name = "sim")
    var sim : Int
)