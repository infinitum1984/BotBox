package com.empty.botbox.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.empty.botbox.models.Bot

@Dao
interface BotDao {
    @Insert
    fun insertBot(bot: Bot)

    @Query("DELETE FROM bots WHERE name = :botName")
    fun deleteBot(botName:String)

    @Query("DELETE FROM bots")
    fun deleteAll()

    @Query("SELECT * FROM bots")
    fun getBots(): LiveData<List<Bot>>
}