package data

data class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}