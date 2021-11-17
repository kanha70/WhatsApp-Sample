package com.example.whatsappsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.sendtext.view.*

class ChatAdapter(
    var dataList: MutableList<Chat>
) :RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sendtext,parent,false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
         holder.itemView.apply {
             tvMessage.text = dataList[position].message.toString()
             tvMessageReceived.text = dataList[position].message.toString()
         }
    }

    override fun getItemCount(): Int {
      return dataList.size
    }
}