fun main() {
    // Задание 1-2. Ввод n числа номеров
    println("Количество телефонов: ")
    var n = readlnOrNull()?.toIntOrNull() ?: return
    while (n <= 0) {
        println("Ошибка: Введите число больше 0\n")
        n = readlnOrNull()?.toIntOrNull() ?: return
    }

    // Задание 3-4. Ввод номеров и получение MutableList через функцию
    val numbers = getNumbers(n)

    // Задание 5. Фильтрация по +7
    println("\nТелефоны с \"+7\":")
    numbers
        .filter { it.contains("+7") } // отсечение
        .forEach { println(it) }

    // Задание 6. Вывод уникальных номеров
    val contactsSet = numbers.toSet()
    println("\nУникальные номера (${contactsSet.size} шт.):")
    contactsSet.forEach {
        println(it)
    }

    // Задание 7. Вывод суммы длин всех номеров
    val sumLength = numbers.sumOf { it.length } // депрекейт symBy
    println("\nСумма длин всех номеров: $sumLength\n")

    // Задание 8. Заполнение Map именами к номерам телефонов
    val contactsAndName: MutableMap<String, String> = mutableMapOf() // номер, имя
    contactsSet.forEach {
        println("Введите имя для номера $it: ")
        val name = readln()
        contactsAndName[it] = name // в ключ записывается имя
    }

    // Задание 9. Вывод всё содержание Map
    contactsAndName.forEach { (number, name) ->
        println("Человек: $name. Номер телефона: $number")
    }

}

// Функция ввода номеров, добавления в список и возврат списка
fun getNumbers(n: Int): MutableList<String> {
    val contacts: MutableList<String> = MutableList(0) { index -> index.toString() }

    for (i in 0 until n) {
        println("Введите номер телефона: ")
        val number = readlnOrNull() ?: "+7(918)366-24-24"
        contacts.add(number)
    }
    return contacts
}