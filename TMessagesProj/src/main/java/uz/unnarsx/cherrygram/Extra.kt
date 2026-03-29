package uz.unnarsx.cherrygram

import android.app.Activity
import org.telegram.tgnet.TLRPC
import org.telegram.ui.ActionBar.BaseFragment

object Extra {

    const val APP_ID: Int = 0
    const val APP_HASH: String = ""
    const val SMS_HASH: String = ""
    const val ENDPOINT_FOR_DATE: String = "https://example.invalid"
    const val ENDPOINT_FOR_DATE_SECRET: String = ""

    @JvmField val HASH_ARRAY = arrayOf("")
    @JvmField val APP_ARRAY = arrayOf("")
    @JvmField val SMS_ARRAY = arrayOf("")

    @JvmField val Name_Arr = arrayOf("")
    @JvmField val Name_Arr2 = arrayOf("")
    @JvmField val Name_Arr3 = arrayOf("")
    @JvmField val Name_ArrTwo = arrayOf("")
    @JvmField val Name_ArrTwo1 = arrayOf("")
    @JvmField val Name_ArrTwo2 = arrayOf("")
    @JvmField val Name_ArrTwo3 = arrayOf("")
    @JvmField val Name_ArrTwo4 = arrayOf("")
    @JvmField val Name_ArrTwo5 = arrayOf("")
    @JvmField val Name_ArrTwo6 = arrayOf("")
    @JvmField val XName_Arr = arrayOf("")
    @JvmField val XName_ArrTwo = arrayOf("")

    @JvmField val FILE_NAME_HASH = arrayOf("")
    @JvmField val GITLAB_RAW_URL_HASH = arrayOf("")
    @JvmField val FILE_NAME_MARKETPLACE_HASH = arrayOf("")
    @JvmField val GITLAB_RAW_URL_MARKETPLACE_HASH = arrayOf("")
    @JvmField val FILE_NAME_BLOCKED_HASH = arrayOf("")
    @JvmField val GITLAB_RAW_URL_BLOCKED_HASH = arrayOf("")
    @JvmField val FILE_NAME_BADGE_COLORS_HASH = arrayOf("")
    @JvmField val GITLAB_RAW_URL_BADGE_COLORS_HASH = arrayOf("")
    @JvmField val FILE_NAME_TON_RATE_HASH = arrayOf("")
    @JvmField val TON_RATE_URL_HASH = arrayOf("")

    fun getProfileDC(user: TLRPC.User?, chat: TLRPC.Chat?): StringBuilder {
        return StringBuilder()
    }

    fun addBirthdayToCalendar(activity: Activity?, userId: Long) {
    }

    fun getRegistrationDate(fragment: BaseFragment?, activity: Activity?, userId: Long, chatId: Long) {
    }
}
