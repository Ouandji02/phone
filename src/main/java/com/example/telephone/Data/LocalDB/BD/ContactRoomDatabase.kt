package com.example.telephone.Data.LocalDB.BD

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.telephone.Data.LocalDB.DAO.ContactDao
import com.example.telephone.Domain.Model.Contact

@Database(entities = [(Contact::class)], version = 1, exportSchema = false)
abstract class ContactRoomDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao
    companion object {
        @Volatile
        private var INSTANCE: ContactRoomDatabase? = null

        fun getInstance(context: Context): ContactRoomDatabase {
            // only one thread of execution at a time can enter this block of code
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ContactRoomDatabase::class.java,
                        "employee_database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}