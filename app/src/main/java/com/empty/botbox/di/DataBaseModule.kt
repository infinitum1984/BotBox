package com.empty.botbox.di

import android.app.Application
import androidx.room.Room
import com.empty.botbox.dp.BotDao
import com.empty.botbox.dp.BotDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


@Module
object DataBaseModule {
    @Provides
    @Singleton
    fun providePokemonDB(application: Application?): BotDb {
        return Room.databaseBuilder(application!!,BotDb::class.java, "Bots")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providePokeDao(botDB: BotDb): BotDao {
        return botDB.botDao()
    }
}