package com.empty.botbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.empty.botbox.sevices.BotsServer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {

        super.onStart()
    }
    override fun onResume() {
        startService(Intent(this, BotsServer::class.java))

        super.onResume()
    }
}
