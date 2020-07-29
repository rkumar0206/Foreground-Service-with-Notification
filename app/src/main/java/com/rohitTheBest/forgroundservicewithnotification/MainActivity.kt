package com.rohitTheBest.forgroundservicewithnotification

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.rohitTheBest.forgroundservicewithnotification.Constants.MESSAGE_KEY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun startService(view: View) {

        val serviceIntent = Intent(this, ForegroundService::class.java)
        intent.putExtra(MESSAGE_KEY, mainEditText.text.toString().trim())

        //startService(serviceIntent)
        ContextCompat.startForegroundService(
            this,
            serviceIntent
        )  //for starting foreground Service


    }

    fun stopService(view: View) {

        val serviceIntent = Intent(this, ForegroundService::class.java)
        stopService(serviceIntent)
    }
}