package com.empty.botbox.repository

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
        bots.add(Bot("1345490424:AAHriw9UacTDZ3x5rMEb8pWWruZMBUiU7Z8","BotBox1"))
        bots.add(Bot("572722769:AAHSBhzTaW9ZHhnVWR1hi8wD1EvpAlqlcMk","SektaBot"))
        bots.add(Bot("556162227:AAFBE3vdWdsBxIPzQan-hXt4LYsBkcrnUxc","MyBot"))

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