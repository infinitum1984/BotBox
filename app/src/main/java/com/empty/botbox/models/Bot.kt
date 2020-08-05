package com.empty.botbox.models

import android.util.Log
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.model.Update
import com.pengrad.telegrambot.request.SendMessage
@Entity(tableName = "bots")
 class Bot(
    val token:String,
    val name:String,
    var description:String="",
    var isOnline:Boolean=false
          ):UpdatesListener{
    @PrimaryKey(autoGenerate = true)
    private var id:Int=0

    @Ignore
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