package com.example.javatokotlin.ui

import android.app.Application
import com.example.javatokotlin.data.di.appModule
import com.example.javatokotlin.data.di.mainModule
import com.example.javatokotlin.data.di.noteModule
import com.example.javatokotlin.data.di.splashModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }

}