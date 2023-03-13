data class Note(val title: String, val body: String) {
    override fun toString(): String {
        return "Имя:\n$title\nОписание:\n$body"
    }
}

class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Archive

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}