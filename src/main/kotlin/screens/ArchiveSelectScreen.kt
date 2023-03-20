package screens

import data.Archive

class ArchiveSelectScreen(data: MutableList<Archive>): Screen<Archive>(data) {

    private val createArchive: () -> Unit = {
        while (true) {
            println("Введите название архива")
            val input = readln()
            val archive = Archive(input)
            if (data.contains(archive)) println("Такой архив уже есть")
            else {
                data.add(archive)
                val index = data.lastIndex
                updateMenu(archive.name to { open(index) })
                break
            }
        }
    }

    override fun buildMenuOptions() {
        menuOptions.add("Создать архив" to createArchive)
        super.buildMenuOptions()
    }

    override fun printDescription() {
        println("Список архивов:")
    }

    override fun open(index: Int) {
        NoteSelectScreen(data[index].notes).show()
    }
}