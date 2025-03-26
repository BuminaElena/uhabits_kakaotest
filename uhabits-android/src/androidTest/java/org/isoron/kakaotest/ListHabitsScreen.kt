package org.isoron.kakaotest

import io.github.kakaocup.kakao.screen.Screen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import org.isoron.uhabits.R

class ListHabitsScreen : Screen<ListHabitsScreen>() {
    val addHabitButton = KTextView { withId(R.id.actionCreateHabit) }
    val sortingButton = KTextView { withId(R.id.action_filter) }
    val menuButton = KButton { withContentDescription(("Ещё")) }
}