package com.empty.botbox.models

import android.util.Log

import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.SendMessage
data class TeleBot(
    val token:String,
    val name:String,
    var description:String="",
    var isOnline:Boolean=false
):UpdatesListener{
    private var id:Int=0

    lateinit var MyTeleBot:TelegramBot

    fun startMe(){
        MyTeleBot= TelegramBot(token)
        MyTeleBot.setUpdatesListener(this)
    }
    override fun process(updates: MutableList<Update>): Int {
        Log.d("BotsServer",updates[0].message().text())
        val chatId = updates[0].message().chat().id();
        val response = MyTeleBot.execute(SendMessage(chatId,"(${name}) you send: ${updates[0].message().text()}"))
        return UpdatesListener.CONFIRMED_UPDATES_ALL
    }


}