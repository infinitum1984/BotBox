package com.empty.botbox.repositories

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.empty.botbox.App
import com.empty.botbox.models.Bot

object BotsRepository {
    private val prefs: SharedPreferences by lazy{
        val ctx = App.getApplicationContext()
        PreferenceManager.getDefaultSharedPreferences(ctx)
    }
    fun saveBots(bots: List<Bot>){
        //TODO save bots

    }
    fun getBots():List<Bot>{
        val bots = arrayListOf<Bot>()
        for (i in 1..20){
            bots.add(Bot(token = "SIMPLETOKEN", name = "BOT_$i", description = if (i%2==0) "test discription $i" else "",
                isOnline = if (i%3==0) true else false))
        }
        return bots
    }
    private fun putValue(pair: Pair<String, Any>) = with(prefs.edit()){
        val key = pair.first
        val value = pair.second
        when(value){
            is String -> putString(key, value)
            is Int -> putInt(key, value)
            is Long ->putLong(key, value)
            is Boolean ->putBoolean(key, value)
            is Float ->putFloat(key, value)

            else-> kotlin.error("Error")
        }
        commit()
    }
}