/**
 * This is the source code of Cherrygram for Android.
 * It is licensed under GNU GPL v. 2 or later.
 * You should have received a copy of the license in this archive (see LICENSE).
 * Please, be respectful and credit the original author if you use this code.
 *
 * Copyright github.com/arsLan4k1390, 2022-2026.
 */

package org.telegram.ui

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.aheaditec.talsec_security.security.api.SuspiciousAppInfo
import com.aheaditec.talsec_security.security.api.Talsec
import com.aheaditec.talsec_security.security.api.TalsecConfig
import com.aheaditec.talsec_security.security.api.ThreatListener
import org.telegram.messenger.ApplicationLoader
import org.telegram.messenger.FileLog
import org.telegram.messenger.HuaweiApplicationLoader
import uz.unnarsx.cherrygram.Extra
import uz.unnarsx.cherrygram.core.configs.CherrygramCoreConfig
import uz.unnarsx.cherrygram.core.helpers.AppRestartHelper
import uz.unnarsx.cherrygram.donates.DonatesManager

class HuaweiApplicationLoaderlmpl : HuaweiApplicationLoader(), ThreatListener.ThreatDetected {
    /** SDK Integration start */
    companion object {
        private const val INTEGRITY_LOG_TAG = "CherrygramIntegrity"
        private const val ENABLE_THREAT_AUTO_RESTART = false
        private val expectedPackageName = getPkgName()

        private val expectedSigningCertificateHashBase64 = arrayOf(
            getPkgHash(), getPkgHashGP()
        ).filter { it.isNotBlank() }.toTypedArray()

        private const val watcherMail = "arslan4k1390@gmail.com"

        private val supportedAlternativeStores = arrayOf(
            "com.android.vending",               // Google Play Store
            "com.sec.android.app.samsungapps",   // Samsung Galaxy Store
            "com.huawei.appmarket",              // Huawei AppGallery
            "com.xiaomi.market",                 // Xiaomi GetApps
            "com.oppo.market",                   // OPPO / Realme / OnePlus
            "com.bbk.appstore",                  // Vivo
            "com.lenovo.leos.appstore",          // Lenovo/Moto
            "com.amazon.venezia"                 // Amazon AppStore
        )

        private const val isProd = true
        private const val killOnBypass = true

        private fun getPkgName() : String {
            val check = Extra.pkg_arrOne + Extra.pkg_arrTwo + Extra.pkg_arrThree
            return check.joinToString().replace(",", "").replace(" ", "")
        }

        private fun getPkgHash() : String {
            val check = Extra.pkg_hashOne + Extra.pkg_hashTwo + Extra.pkg_hashThree
            return check.joinToString().replace(",", "").replace(" ", "")
        }

        private fun getPkgHashGP() : String {
            val check = Extra.pkg_hashGPOne + Extra.pkg_hashGPTwo + Extra.pkg_hashGPThree
            return check.joinToString().replace(",", "").replace(" ", "")
        }
    }

    override fun onCreate() {
        super.onCreate()

        if (expectedPackageName.isBlank() || expectedSigningCertificateHashBase64.isEmpty()) {
            return
        }

        try {
            val config = TalsecConfig.Builder(expectedPackageName, expectedSigningCertificateHashBase64)
                .watcherMail(watcherMail)
                .supportedAlternativeStores(supportedAlternativeStores)
                .prod(isProd)
                .killOnBypass(killOnBypass)
                .build()

            ThreatListener(this, null, null).registerListener(this)
            Talsec.start(this, config)
        } catch (e: Throwable) {
            FileLog.e(e)
        }

        /*registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                Talsec.blockScreenCapture(activity, false)
            }
            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {
                ScreenProtector.INSTANCE.registerScreenCallbacks(activity)
            }
            override fun onActivityPaused(activity: Activity) {
                ScreenProtector.INSTANCE.unregisterScreenCallbacks(activity)
            }
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}
            override fun onActivityDestroyed(activity: Activity) {}
        })*/
    }

    override fun onRootDetected() {
        handleThreat("onRootDetected", !DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications)
    }

    override fun onDebuggerDetected() {
        handleThreat("onDebuggerDetected", true)
    }

    override fun onEmulatorDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onTamperDetected() {
        handleThreat("onTamperDetected", true)
    }

    override fun onUntrustedInstallationSourceDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onHookDetected() {
        handleThreat("onHookDetected", !DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications)
    }

    override fun onDeviceBindingDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onObfuscationIssuesDetected() {
        handleThreat("onObfuscationIssuesDetected", true)
    }

    override fun onMalwareDetected(suspiciousApps: List<SuspiciousAppInfo>) {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onScreenshotDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onScreenRecordingDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onMultiInstanceDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onUnsecureWifiDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onTimeSpoofingDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }

    override fun onLocationSpoofingDetected() {
//        if (!DonatesManager.checkAllDonatedAccountsForMarketplace() && !CherrygramCoreConfig.showNotifications) uh()
    }
    /** SDK Integration finish */

    private fun handleThreat(reason: String, shouldRestart: Boolean) {
        val message = "[cg-integrity] $reason detected, shouldRestart=$shouldRestart, autoRestartEnabled=$ENABLE_THREAT_AUTO_RESTART"
        Log.e(INTEGRITY_LOG_TAG, message)
        FileLog.w(message)
        if (ENABLE_THREAT_AUTO_RESTART && shouldRestart) {
            uh(reason)
        }
    }

    private fun uh(reason: String) {
        val message = "[cg-integrity] scheduling app restart due to $reason"
        Log.e(INTEGRITY_LOG_TAG, message)
        FileLog.w(message)
        Handler(Looper.getMainLooper()).postDelayed({
            AppRestartHelper.restartApp(ApplicationLoader.applicationContext)
        }, 15_000)
    }

}
