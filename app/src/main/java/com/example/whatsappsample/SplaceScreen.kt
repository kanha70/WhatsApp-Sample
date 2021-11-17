package com.example.whatsappsample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplaceScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen)

        Handler().postDelayed({
                              val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        },3000)
    }
}