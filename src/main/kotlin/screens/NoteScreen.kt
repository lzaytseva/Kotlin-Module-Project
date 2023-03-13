package screens

import data.Note

class NoteScreen(data: MutableList<Note>, private val index: Int): Screen<Note>(data) {

    override fun buildMenuOptions() {
        menuOptions.add("Открыть заметку" to { open(index) })
        menuOptions.add("Выход" to exit)
    }

    override fun printDescription() {
        println("Заметка ${data[index].title}:")
    }

    override fun open(index: Int) {
        println(data[index].getFullNote())
    }
}