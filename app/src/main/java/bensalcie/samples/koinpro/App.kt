package bensalcie.samples.koinpro

import android.app.Application
import bensalcie.samples.koinpro.di.activityModule
import bensalcie.samples.koinpro.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import java.util.logging.Logger

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(appModules, activityModule)
        }
    }
}