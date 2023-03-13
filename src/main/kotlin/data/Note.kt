package data

data class Note(val title: String, val body: String) {
    override fun toString(): String {
        return title
    }
    fun getFullNote(): String {
        return "Заголовок:\n$title\nТекст заметки:\n$body"
    }
}