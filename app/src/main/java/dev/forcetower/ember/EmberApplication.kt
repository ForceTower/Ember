package dev.forcetower.ember

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class EmberApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // "Every time you log in production, a puppy dies"
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}