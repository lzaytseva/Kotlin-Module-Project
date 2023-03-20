package data

import menu.MenuOption

data class Archive(val name: String): MenuOption {
    val notes = mutableListOf<Note>()

    override val menuOption: String
        get() = this.name
}