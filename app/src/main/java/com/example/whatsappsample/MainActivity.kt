package com.example.whatsappsample

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val CHANNEL_ID = "channelID"
    val CHANNEL_NAME = "channelName"
    val NOTIFICATION_ID = 0

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)
            createNotificationChannel()

                val pendingIntent = TaskStackBuilder.create(this).run {
                    addNextIntentWithParentStack(intent)
                    getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
                }

            val notification = NotificationCompat.Builder(this,CHANNEL_ID)
                    .setContentText("You got a new Message")
                    .setSmallIcon(R.drawable.ic_action_name)
                    .setPriority(NotificationCompat.PRIORITY_HIGH)
                    .setContentIntent(pendingIntent)
                    .build()

           val notificationManager = NotificationManagerCompat.from(this)


           var chatList = mutableListOf(
               Chat("Welcome")

           )
           val adapter = ChatAdapter(chatList)
           rvChatScreen.adapter = adapter
           rvChatScreen.layoutManager = LinearLayoutManager(this)

           ibSend.setOnClickListener {
               val title = etMessage.text.toString()
               val todo = Chat(title)
               chatList.add(todo)
               adapter.notifyItemInserted(chatList.size - 1)
               etMessage.text.clear()
               notificationManager.notify(NOTIFICATION_ID,notification)

           }
       }

    fun createNotificationChannel(){
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
              val channel = NotificationChannel(CHANNEL_ID,CHANNEL_NAME,
                  NotificationManager.IMPORTANCE_HIGH).apply {
              }
              val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
              manager.createNotificationChannel(channel)
          }
      }

}