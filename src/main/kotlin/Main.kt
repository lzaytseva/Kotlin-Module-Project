
fun main() {
    println("Добро пожаловать (нет) в приложение 'Заметки'")
    val archivesList = mutableListOf<Archive>()
    ArchiveSelectScreen(archivesList).show()
}