package com.example.myapplication
import android.app.Application
import com.securevale.rasp.android.native.SecureApp

class SocialApp: Application() {
    override fun onCreate() {
        super.onCreate()
        SecureApp.init()
    }
}