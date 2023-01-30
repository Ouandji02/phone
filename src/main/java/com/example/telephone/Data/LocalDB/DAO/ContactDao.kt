package com.example.telephone.Data.LocalDB.DAO

import androidx.room.Dao
import androidx.room.Delete
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
    suspend fun getContact(phone : String) : Contact
    @Query("SELECT *FROM contact")
    suspend fun getAllContact() : List<Contact>
    @Update
    suspend fun updateContact(contact: Contact) : Void
    @Delete
    suspend fun deleteContact(contact: Contact) : Void
}