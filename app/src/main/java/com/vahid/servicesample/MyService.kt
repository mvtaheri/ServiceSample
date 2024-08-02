package com.vahid.servicesample

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class MyService : Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> {
                start(intent)
            }

            Actions.STOP.toString() -> {
                stopSelf()
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start(intent: Intent?) {
        val notification = NotificationCompat.Builder(this, "service_notification_channel")
            .setContentText("Elapsed time: 00:50")
            .setContentTitle("Run is Active")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .build()
        startForeground(1, notification)
    }

    private fun stop() {}

    enum class Actions {
        START,
        STOP
    }
}