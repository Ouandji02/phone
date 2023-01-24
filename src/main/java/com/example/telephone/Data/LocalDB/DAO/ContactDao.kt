package com.example.telephone.Data.LocalDB.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.telephone.Domain.Model.Contact

@Dao
interface ContactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addContact(contact: Contact) : Void
    @Query("SELECT * FROM contact WHERE phone = :phone ")
    fun getContact(phone : String) : Contact
    @Query("SELECT *FROM contact")
    fun getAllContact() : List<Contact>
    @Update
    suspend fun updateContact(contact: Contact) : Void
}