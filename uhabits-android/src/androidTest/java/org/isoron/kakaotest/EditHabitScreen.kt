package org.isoron.kakaotest

import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import org.isoron.uhabits.R

class EditHabitScreen: Screen<ListHabitsScreen>() {
    val nameInput = KEditText { withId(R.id.nameInput) }
    val questionInput = KEditText { withId(R.id.questionInput) }
    val descriptionInput = KEditText { withId(R.id.notesInput) }
    val frequencyPicker = KButton { withId(R.id.boolean_frequency_picker) }
    val everyDayRadioButton = KButton { withId(R.id.everyDayRadioButton) }
    val xTimesPerMonthRadioButton = KButton { withId(R.id.xTimesPerMonthRadioButton) }
    val buttonSave = KButton { withId(R.id.buttonSave) }
}