package com.empty.botbox.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.empty.botbox.models.Bot
import com.empty.botbox.repository.BotsRepository

class BotsViewModel: ViewModel() {
    fun getBotsData():LiveData<List<Bot>>{
        val data = MutableLiveData<List<Bot>>()
        data.value=loadBots()
        return data
    }
    val botsRepository=BotsRepository
    private fun loadBots():List<Bot>{
        val bots = botsRepository.getBots()
        return bots
    }

}