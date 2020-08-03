package com.empty.botbox.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.empty.botbox.R
import com.empty.botbox.models.Bot
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_bot_single.*

class BotsAdapter(val listener:(Bot) -> Unit):RecyclerView.Adapter<BotsAdapter.SingleBotViewHolder>() {

    var items:List<Bot> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleBotViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        val convertView = inflater.inflate(R.layout.item_bot_single,parent,false)
        return SingleBotViewHolder(convertView)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: SingleBotViewHolder, position: Int) {
        holder.bind(items[position],listener)
    }
    fun updateData(list_bots:List<Bot>){
        items=list_bots
        notifyDataSetChanged()
    }
    class SingleBotViewHolder(override val containerView: View):RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item :Bot,listener: (Bot) -> Unit){
            tv_title_single.text=item.name
            tv_desctiption_single.text=item.description
            sv_indicator.visibility=if (item.isOnline) View.VISIBLE else View.GONE
            containerView.setOnClickListener {
                listener.invoke(item)
            }
        }
    }
}