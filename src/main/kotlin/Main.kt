import data.Archive
import screens.ArchiveSelectScreen

fun main() {
    println("Добро пожаловать в приложение 'Заметки'")
    val archivesList = mutableListOf<Archive>()
    ArchiveSelectScreen(archivesList).show()
}