package com.vahid.servicesample

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent

class ApplicationService : Application() {
    override fun onCreate() {
        super.onCreate()
        val notificationChannel = NotificationChannel(
            "service_notification_channel",
            "Running Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        val notifiicationservice =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notifiicationservice.createNotificationChannel(notificationChannel)
    }
}