package com.example.telephone

import android.app.Application
import com.example.telephone.di.contactModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class EntryApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@EntryApplication)
            modules(contactModule)
        }
    }
}