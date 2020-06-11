package com.empty.botbox.ui.bots

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.empty.botbox.R
import com.empty.botbox.ui.adapters.BotsAdapter
import com.empty.botbox.viewmodels.BotsViewModel
import kotlinx.android.synthetic.main.activity_bots.*

class BotsActivity : AppCompatActivity() {
    private lateinit var viewModel:BotsViewModel
    private lateinit var botsAdapter:BotsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bots)
        initViewModels()
        initViews()
        initToolbar()
    }
    fun initViewModels(){
        viewModel= ViewModelProviders.of(this).get(BotsViewModel::class.java)
        botsAdapter= BotsAdapter()
        botsAdapter.updateData(viewModel.getBotsData().value!!)

    }
    fun initViews(){
        with(rv_bot_list){
            layoutManager=LinearLayoutManager(this@BotsActivity)
            adapter=botsAdapter
        }
    }
    fun initToolbar(){
        //TODO make toolbar
    }
}