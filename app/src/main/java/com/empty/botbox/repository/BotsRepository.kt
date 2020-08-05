package com.empty.botbox.repository

import android.app.Application
import com.empty.botbox.db.BotDao
import com.empty.botbox.db.BotDb
import com.empty.botbox.models.Bot
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

//        bots.add(Bot("1345490424:AAHriw9UacTDZ3x5rMEb8pWWruZMBUiU7Z8", "BotBox1"))
//        bots.add(Bot("572722769:AAHSBhzTaW9ZHhnVWR1hi8wD1EvpAlqlcMk", "SektaBot"))
//        bots.add(Bot("556162227:AAFBE3vdWdsBxIPzQan-hXt4LYsBkcrnUxc", "MyBot"))

class BotsRepository(application: Application) : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
    private var botDao: BotDao?

    init {
        val db = BotDb.getDatabase(application)
        botDao = db?.botDao()
    }

    fun getBots() = botDao?.getBots()
    fun insertBot(bot: Bot) {
        launch {
            setBotBG(bot)
        }
    }

    private suspend fun setBotBG(bot: Bot) {
        withContext(Dispatchers.IO) {
            botDao?.insertBot(bot)
        }
    }

}