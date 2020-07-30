package com.rohitTheBest.forgroundservicewithnotification

import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.rohitTheBest.forgroundservicewithnotification.Constants.CHANNEL_ID
import com.rohitTheBest.forgroundservicewithnotification.Constants.MESSAGE_KEY

class ForegroundService : Service() {

    //This Method is only called Once
    override fun onCreate() {
        super.onCreate()
    }

    //This Method is called everyTime a service is started
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val message = intent?.getStringExtra(MESSAGE_KEY)

        //Handling Click event
        val foregroundServiceIntent = Intent(this, MainActivity::class.java)
        val foregroundPendingIntent = PendingIntent.getActivity(
            this,
            0, foregroundServiceIntent, 0
        )


        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Example foreground Service")
            .setContentText(message)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentIntent(foregroundPendingIntent)
            .build()

        startForeground(10, notification)

        //For heavy operation start new thread

        /*SystemClock.sleep(5000)
        stopSelf()  //Will stop all the services itself
*/
        return START_NOT_STICKY  //will not start the service again
    }


    //After a service is stopped onDestroy() method is called
    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {

        return null
    }
}