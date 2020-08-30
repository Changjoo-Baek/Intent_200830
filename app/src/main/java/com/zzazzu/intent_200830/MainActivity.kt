package com.zzazzu.intent_200830

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moveToOtherActivityBtn.setOnClickListener {

            val myIntent = Intent(this, other::class.java)
            startActivity(myIntent)

        }

        sendMessageBtn.setOnClickListener {

            val inputMessage = messageEdt.text.toString()

            val myIntent = Intent(this,  message::class.java)

            myIntent.putExtra("message", inputMessage)

            startActivity(myIntent)
        }

    }
}