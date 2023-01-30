package com.example.telephone.di

import android.app.Application
import androidx.room.Room
import com.example.telephone.Data.LocalDB.BD.ContactRoomDatabase
import com.example.telephone.Data.LocalDB.DAO.ContactDao
import com.example.telephone.Data.RepositoryImpl.ContactRepositoryImpl
import com.example.telephone.Domain.Repository.ContactRepository
import com.example.telephone.Domain.UseCases.ContactUseCases
import com.example.telephone.ui.presentation.ContactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


fun providesDatabase(application: Application) = Room.databaseBuilder(
    application,
    ContactRoomDatabase::class.java,
    "contact_database"
).fallbackToDestructiveMigration()
    .build()

fun provideDao(db: ContactRoomDatabase) = db.getContactDao()

val contactModule = module {

    single {
        providesDatabase(get())
    }
    single {
        provideDao(get())
    }
    single<ContactRepository> {
        ContactRepositoryImpl(get())
    }
    single {
        ContactUseCases(get())
    }
    viewModel {
        ContactViewModel(get())
    }
}