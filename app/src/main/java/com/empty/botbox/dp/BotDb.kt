package com.empty.botbox.dp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.empty.botbox.models.Bot

@Database(entities = [Bot::class],version = 2,exportSchema = false)
abstract class BotDb: RoomDatabase() {
    abstract fun botDao():BotDao
}