package com.empty.botbox.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.empty.botbox.models.Bot
import com.empty.botbox.repository.BotsRepository

class BotsViewModel(application: Application): AndroidViewModel(application) {
    private var repository:BotsRepository= BotsRepository(application)

    fun getBots()=repository.getBots()

    fun setBots(bot: Bot){repository.insertBot(bot)}

}