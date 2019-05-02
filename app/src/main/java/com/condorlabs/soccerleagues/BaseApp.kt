package com.condorlabs.soccerleagues

import android.app.Activity
import android.app.Application
import android.app.Service
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatDelegate
import timber.log.Timber
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class BaseApp : Application(), LifecycleObserver {


    override fun attachBaseContext(context: Context) {
        super.attachBaseContext(context)

    }

    override fun onCreate() {
        super.onCreate()

        // Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        // Calligraphy
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Nunito/Nunito-SemiBold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)


    }

}
