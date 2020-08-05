package com.empty.botbox.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.empty.botbox.models.Bot

@Database(entities = [Bot::class],version = 1,exportSchema = false)
abstract class BotDb: RoomDatabase() {
    abstract fun botDao():BotDao

    companion object{
        @Volatile
        private var INSTANCE: BotDb?=null
        fun getDatabase(context: Context):BotDb?{
            if (INSTANCE == null){
                synchronized(BotDb::class.java){
                    if (INSTANCE==null){
                        INSTANCE=Room.databaseBuilder(
                            context.applicationContext,
                            BotDb::class.java,"bots_database"
                        ).build()
                    }
                }
            }
            return INSTANCE
        }

    }
}