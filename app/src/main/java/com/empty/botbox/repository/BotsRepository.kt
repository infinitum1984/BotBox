package com.empty.botbox.repository

import android.content.SharedPreferences
import android.database.Observable
import android.preference.PreferenceManager
import androidx.lifecycle.MutableLiveData
import com.empty.botbox.App
import com.empty.botbox.dp.BotDao
import com.empty.botbox.models.Bot
import com.empty.botbox.models.BotResponse
import com.empty.botbox.network.BotApiServices
import java.util.*
import javax.inject.Inject

class BotsRepository {
    val botDao: BotDao
    val apiServices: BotApiServices

    @Inject
    constructor( botDao: BotDao,
                 apiServices: BotApiServices){
        this.botDao=botDao
        this.apiServices=apiServices
    }

    fun insertBot(bot:Bot){
        botDao.insertBot(bot)
    }
    fun getBots(): MutableLiveData<List<Bot>> {
//        val bots = arrayListOf<Bot>()
//        bots.add(Bot("1345490424:AAHriw9UacTDZ3x5rMEb8pWWruZMBUiU7Z8", "BotBox1"))
//        bots.add(Bot("572722769:AAHSBhzTaW9ZHhnVWR1hi8wD1EvpAlqlcMk", "SektaBot"))
//        bots.add(Bot("556162227:AAFBE3vdWdsBxIPzQan-hXt4LYsBkcrnUxc", "MyBot"))

        return botDao.getBots()
    }
    fun deleteAll(){
        botDao.deleteAll()
    }


}