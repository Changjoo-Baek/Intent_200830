package com.zzazzu.intent_200830

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_message.*

class message : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)
// 화면이 만들어질 때

        val receivedMessage = intent.getStringExtra("message")



        messageTxt.text = receivedMessage

    }
}