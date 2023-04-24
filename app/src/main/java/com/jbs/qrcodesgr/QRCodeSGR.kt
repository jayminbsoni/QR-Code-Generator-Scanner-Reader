package com.jbs.qrcodesgr

import android.app.Application
import android.content.Context
import android.os.StrictMode
import com.jbs.qrcodesgr.utils.Constants
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
open class QRCodeSGR : Application() {

    companion object {
        lateinit var appContext: Context
    }

    //region #InBuilt Methods
    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        appContext = this
    }

    override fun onCreate() {
        super.onCreate()
        // Configure Strict Mode
        configureStrictMode()

        // Initialize Common Configuration of the application
        initialization()
    }
    //endregion

    //region #Custom Methods
    /**
     * Configure Strict Mode
     */
    private fun configureStrictMode() {
        // Check Thread and VM policy to detect warnings of threads, intent service and ANRs etc.
        // Check Logcat for more info
        if (BuildConfig.DEBUG && Constants.IS_STRICT_MODE_ENABLE) {
            StrictMode.setThreadPolicy(
                StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog()
                    .build(),
            )

            StrictMode.setVmPolicy(
                StrictMode.VmPolicy.Builder().detectLeakedSqlLiteObjects().detectLeakedClosableObjects().penaltyLog()
                    .penaltyDeath().build(),
            )
        }
    }

    /**
     * Initialize Common Configuration of the application
     */
    private fun initialization() {
        // Configure Timber - Enable Logging for Debug Build only
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
    //endregion
}
