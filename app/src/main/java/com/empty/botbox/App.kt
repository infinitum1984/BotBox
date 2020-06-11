package com.empty.botbox

import android.app.Application
import android.content.Context

class App: Application() {
    companion object{
        lateinit var instances:Application
        fun getApplicationContext(): Context = instances.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instances=this
    }
}