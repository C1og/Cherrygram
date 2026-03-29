package uz.unnarsx.cherrygram.chats.filters

import android.app.Activity
import android.content.SharedPreferences
import androidx.core.content.edit
import org.telegram.messenger.ApplicationLoader
import org.telegram.messenger.MessageObject
import org.telegram.tgnet.TLRPC

object MessagesFilterHelper {

    private val sharedPreferences: SharedPreferences =
        ApplicationLoader.applicationContext.getSharedPreferences("mainconfig", Activity.MODE_PRIVATE)

    fun getExcludedList(): String = "CP_MsgFiltersExcludedChats"

    fun saveArrayList(list: ArrayList<String>, key: String) {
        sharedPreferences.edit {
            putString(key, list.joinToString(","))
        }
    }

    fun getArrayList(key: String): ArrayList<String> {
        val raw = sharedPreferences.getString(key, "").orEmpty()
        if (raw.isBlank()) {
            return arrayListOf()
        }
        return ArrayList(raw.split(",").filter { it.isNotBlank() })
    }

    fun getExcludedChatsCount(): Int = getArrayList(getExcludedList()).size

    fun shouldBlockMessage(messageObject: MessageObject): Boolean = false

    fun addSpoilerEntities(messageObject: MessageObject): ArrayList<TLRPC.MessageEntity>? {
        return messageObject.messageOwner?.entities
    }

    fun addSpoilerEntities(
        messageObject: MessageObject,
        original: ArrayList<TLRPC.MessageEntity>?
    ): ArrayList<TLRPC.MessageEntity>? {
        return original
    }

    fun addSpoilerEntities(text: String): String = text
}
