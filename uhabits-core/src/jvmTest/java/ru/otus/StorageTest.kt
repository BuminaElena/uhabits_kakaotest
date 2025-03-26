package ru.otus

import org.isoron.uhabits.core.preferences.Preferences
import org.junit.Assert
import org.junit.Test

class StorageTest {

    @Test
    fun testStorage() {
        val storage = MemoryStorage()
        storage.putBoolean("putBool", true)
        Assert.assertTrue(storage.getBoolean("putBool", false))
    }

    @Test
    fun testPreferences() {
        val storage = MemoryStorage()
        val pref = Preferences(storage)
        Assert.assertFalse(pref.isDeveloper)
        pref.isDeveloper = true
        Assert.assertTrue(pref.isDeveloper)
    }
}