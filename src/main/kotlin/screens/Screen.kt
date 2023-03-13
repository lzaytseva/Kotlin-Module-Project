package screens

abstract class Screen<T> (val data: MutableList<T>) {

    private var running = true
    val menuOptions = mutableListOf<Pair<String, () -> Unit>>()

    fun show() {
        buildMenuOptions()
        while (running) {
            printDescription()
            printMenu()
            executeAction()
        }
    }

    open fun buildMenuOptions() {
        data.forEachIndexed {index, elem -> menuOptions.add(Pair(elem.toString()) { open(index) }) }
        menuOptions.add(Pair("Выход", exit))
    }

    fun updateMenu(option: Pair<String, () -> Unit>) {
        menuOptions.add(menuOptions.lastIndex, option)
    }

    abstract fun open(index: Int)

    abstract fun printDescription()

    private fun printMenu() {
        menuOptions.forEachIndexed { index, pair -> println("$index. ${pair.first}")  }
    }

    private fun executeAction() {
        val action = getInput()
        menuOptions[action].second.invoke()
    }

    private fun getInput(): Int {
        while (true) {
            println("Введите номер пункта меню")
            when (val input = readln().toIntOrNull()) {
                null -> println("Вы ввели не цифру, попробуйте еще раз")
                !in menuOptions.indices -> println("Такого пункта меню нет, попробуйте еще раз")
                else -> return input
            }
        }
    }

    val exit: () -> Unit = {
        running = false
    }
}