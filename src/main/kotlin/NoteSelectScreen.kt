
class NoteSelectScreen(data: MutableList<Note>): Screen<Note>(data) {

    private val createNote: () -> Unit = {
        println("Введите имя заметки")
        val title = readln()
        println("Введите описание заметки")
        val body = readln()
        val note = Note(title, body)
        data.add(note)
        menuOptions.add(menuOptions.lastIndex, Pair(note.title) { open(data.lastIndex) })


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