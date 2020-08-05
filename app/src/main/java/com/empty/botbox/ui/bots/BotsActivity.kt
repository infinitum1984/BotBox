package com.empty.botbox.ui.bots

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.empty.botbox.R
import com.empty.botbox.adapters.BotsAdapter
import com.empty.botbox.models.Bot
import com.empty.botbox.sevices.BotsServer
import com.empty.botbox.viewmodel.BotsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_bots.*

class BotsActivity : AppCompatActivity() {
    private lateinit var viewModel:BotsViewModel
    private lateinit var botsAdapter:BotsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bots)


        initViewModels()
        initToolbar()
        initViews()
        //runBot()

    }

    override fun onStart() {
        super.onStart()

    }
    fun initViewModels(){
        viewModel= ViewModelProviders.of(this).get(BotsViewModel::class.java)
        viewModel.getBots()?.observe(this,Observer<List<Bot>>{
            this.renderBot(it)
        })


    }
    fun initViews(){
        fab_add.setOnClickListener {
            viewModel.setBots(Bot(0,"1345490424:AAHriw9UacTDZ3x5rMEb8pWWruZMBUiU7Z8", "BotBox1"))
            viewModel.setBots(Bot(0,"572722769:AAHSBhzTaW9ZHhnVWR1hi8wD1EvpAlqlcMk","SektaBot"))
            viewModel.setBots(Bot(0,"556162227:AAFBE3vdWdsBxIPzQan-hXt4LYsBkcrnUxc","MyBot"))
        }
    }
    fun initToolbar(){
        //TODO make toolbar
    }
    fun runBot(){
        startService(Intent(this, BotsServer::class.java))
    }
    fun renderBot(bots: List<Bot>){
        botsAdapter=BotsAdapter({
            Snackbar.make(rv_bot_list,it.name,Snackbar.LENGTH_SHORT).show()

        })
        botsAdapter.updateData(bots)
        val layoutManager=LinearLayoutManager(this)
        rv_bot_list.layoutManager=layoutManager
        rv_bot_list.adapter=botsAdapter

    }
}