package com.empty.botbox.models

import com.pengrad.telegrambot.TelegramBot

class Bot(
    val token:String,
    val name:String,
    var description:String="",
    var isOnline:Boolean=false

          ):TelegramBot(token) {
    init {

    }

    fun start(){

    }

}