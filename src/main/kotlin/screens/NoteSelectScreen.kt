package screens

import data.Note


class NoteSelectScreen(data: MutableList<Note>): Screen<Note>(data) {

    private val createNote: () -> Unit = {
        var title: String

        println("Введите имя заметки")
        while (true) {
            title = readln()
            if (title.isBlank()) println("Введите непустой заголовок")
            else break
        }

        println("Введите описание заметки")
        var body = readln()
        if (body.isEmpty()) body = "<No description>"

        val note = Note(title, body)
        data.add(note)

        val index = data.lastIndex
        updateMenu(note.title to { open(index) })
    }

    override fun buildMenuOptions() {
        menuOptions.add("Создать заметку" to createNote)
        super.buildMenuOptions()
    }

    override fun printDescription() {
        println("Список заметок:")
    }

    override fun open(index: Int) {
        NoteScreen(data, index).show()
    }
}