package org.isoron.kakaotest

import androidx.test.uiautomator.By
import androidx.test.uiautomator.Until
import io.github.kakaocup.kakao.text.KTextView
import io.qameta.allure.android.allureScreenshot
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import io.qameta.allure.kotlin.junit4.DisplayName
import org.isoron.uhabits.BaseUserInterfaceTest
import org.isoron.uhabits.activities.habits.list.ListHabitsActivity
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AllureAndroidJUnit4::class)
class KakaoHabitsTest : BaseUserInterfaceTest(){

    val listHabitsScreen = ListHabitsScreen()
    val editHabitScreen = EditHabitScreen()

    @Test
    @DisplayName("Проверка добавления привычки")
    fun addHabit() {
        val habitName = "myNewHabit"
        val question = "Have you done myNewHabit today?"
        val description = "description for myNewHabit"
        launchApp()
        createDailyHabit(habitName, question, description)
        KTextView {withText(habitName)}.isDisplayed()
    }

    @Test
    @DisplayName("Проверка удаления привычки")
    fun deleteHabit() {
        val habitName = "habitForDelete"
        launchApp()
        createDailyHabit(habitName, "question", "")
        clickText(habitName)
        selectMenu("Удалить")
        clickText("Да")
        KTextView {withText(habitName)}.doesNotExist()
    }

    @Test
    @DisplayName("Проверка сортировки привычек по алфавиту")
    fun checkHabitsAlphabetSorting() {
        val habitName1 = randomString(5)
        val habitName2 = randomString(5)
        val habits = listOf(
            habitName1,
            habitName2,
            "Wake up early",
            "Read books",
            "Meditate",
            "Track time").sorted()
        launchApp()
        createDailyHabit(habitName1, "", "")
        createDailyHabit(habitName2, "", "")
        selectSorting("По названию")
        allureScreenshot("sorting.png")
        checkHabitsOrder(habits)
    }

    fun launchApp() {
        startActivity(ListHabitsActivity::class.java)
        assertTrue(
            device.wait(Until.hasObject(By.pkg("org.isoron.uhabits")), 10000)
        )
        device.waitForIdle()
    }

    fun clickText(text: String) {
        KTextView {withText(text)}.click()
    }

    fun fillDailyHabit(name: String, question: String, description: String) {
        editHabitScreen.nameInput.typeText(name)
        editHabitScreen.questionInput.typeText(question)
        editHabitScreen.descriptionInput.typeText(description)
    }

    fun createDailyHabit(name: String, question: String, description: String) {
        listHabitsScreen.addHabitButton.click()
        clickText("Да или Нет")
        fillDailyHabit(name, question, description)
        editHabitScreen.frequencyPicker.click()
        editHabitScreen.everyDayRadioButton.click()
        clickText("Сохранить")
        editHabitScreen.buttonSave.click()
    }

    fun selectMenu(menuItem: String) {
        listHabitsScreen.menuButton.click()
        clickText(menuItem)
    }

    fun selectSorting(sorting: String) {
        listHabitsScreen.sortingButton.click()
        clickText("Сортировка")
        clickText(sorting)
    }

    fun randomString(length: Int) : String {
        val charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }

    fun checkHabitsOrder(habits: List<String>) {
        val objects = device.findObjects(By.clazz("android.widget.TextView").hasAncestor(By.clazz("android.widget.FrameLayout")).minDepth(9))
        val texts = objects.map { it.text }.toList()
        assertEquals(habits, texts)
    }


}