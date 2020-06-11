package com.empty.botbox.sevices

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.pengrad.telegrambot.TelegramBot
import com.pengrad.telegrambot.UpdatesListener
import com.pengrad.telegrambot.request.SendMessage


class BotsServer : Service() {
    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) startMyOwnForeground() else

            startForeground(
            1,
            Notification()
        )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun startMyOwnForeground() {
        val NOTIFICATION_CHANNEL_ID = "BotBox"
        val channelName = "Bot Box app"
        val chan = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            channelName,
            NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val manager =
            (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
        manager.createNotificationChannel(chan)
        val notificationBuilder =
            NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
        val notification: Notification = notificationBuilder.setOngoing(true)
            .setContentTitle("App is running in background")
            .setPriority(NotificationManager.IMPORTANCE_MIN)
            .setCategory(Notification.CATEGORY_SERVICE)
            .build()
        startForeground(2, notification)
    }
    @SuppressLint("WrongConstant")
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val bot = TelegramBot("572722769:AAHSBhzTaW9ZHhnVWR1hi8wD1EvpAlqlcMk")// @sectaa_bot:
        bot.setUpdatesListener {
            Log.d("BotsServer",it[0].message().text())
            val chatId = it[0].message().chat().id();
            val response = bot.execute(SendMessage(chatId,"you send: ${it[0].message().text()}"))
            UpdatesListener.CONFIRMED_UPDATES_ALL
        }

        val bot2 = TelegramBot("556162227:AAFBE3vdWdsBxIPzQan-hXt4LYsBkcrnUxc")
        bot2.setUpdatesListener {
            Log.d("BotsServer",it[0].message().text())
            val chatId = it[0].message().chat().id();
            val response = bot2.execute(SendMessage(chatId,"(bot2) you send: ${it[0].message().text()}"))// @my_testtt_bot:
            UpdatesListener.CONFIRMED_UPDATES_ALL
        }


        return super.onStartCommand(intent, flags, startId)
    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
