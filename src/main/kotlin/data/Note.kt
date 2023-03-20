package data

import menu.MenuOption

data class Note(val title: String, val body: String): MenuOption {
    override fun toString(): String {
        return "Заголовок:\n$title\nТекст заметки:\n$body"
    }

    override val menuOption: String
        get() = this.title
}