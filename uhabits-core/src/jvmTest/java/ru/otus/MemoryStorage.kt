package ru.otus

import org.isoron.uhabits.core.preferences.Preferences

class MemoryStorage: Preferences.Storage {

    private val storage = mutableMapOf<String, Any>()

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun getBoolean(key: String, defValue: Boolean): Boolean {
        val result = storage[key] ?: defValue
        return result as Boolean
    }

    override fun getInt(key: String, defValue: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getLong(key: String, defValue: Long): Long {
        TODO("Not yet implemented")
    }

    override fun getString(key: String, defValue: String): String {
        TODO("Not yet implemented")
    }

    override fun onAttached(preferences: Preferences) {
    }

    override fun putBoolean(key: String, value: Boolean) {
        storage[key] = value
    }

    override fun putInt(key: String, value: Int) {
        TODO("Not yet implemented")
    }

    override fun putLong(key: String, value: Long) {
        TODO("Not yet implemented")
    }

    override fun putString(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun remove(key: String) {
        TODO("Not yet implemented")
    }
}