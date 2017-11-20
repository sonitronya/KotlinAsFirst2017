@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import java.lang.Math.*

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double = sqrt(v.map { it * it }.sum())

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double = TODO()

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val sred = list.sum() / list.size
    for (i in 0 until list.size)
        list[i] -= sred
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in 0 until a.size) {
        c += a[i] * b[i]
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    var element = 0.0
    for (i in 0 until p.size) {
        element += (p[i] * pow(x, i + 0.0))
    }
    return element
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> = TODO()

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    var mult = 2
    val list = mutableListOf<Int>()
    var number = n
    while (number > 1) {
        if (number % mult == 0) {
            list += mult
            number /= mult
        } else mult++
    }
    return list
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = factorize(n).joinToString(separator = "*")

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var number = n
    val list = mutableListOf<Int>()
    while (number > 0) {
        val del = number / base
        val remain = number - del * base
        list.add(0, remain)
        number /= base
    }
    return list
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var result = ""
    var letter = ""
    var number = n
    while (number > 0) {
        val del = number / base
        var remain = number - del * base
        when {
            (remain == 10) -> letter = 'a'.toString()
            (remain == 11) -> letter = 'b'.toString()
            (remain == 12) -> letter = 'c'.toString()
            (remain == 13) -> letter = 'd'.toString()
            (remain == 14) -> letter = 'e'.toString()
            (remain == 15) -> letter = 'f'.toString()
            (remain == 16) -> letter = 'g'.toString()
            (remain == 17) -> letter = 'h'.toString()
            (remain == 18) -> letter = 'i'.toString()
            (remain == 19) -> letter = 'j'.toString()
            (remain == 20) -> letter = 'k'.toString()
            (remain == 21) -> letter = 'l'.toString()
            (remain == 22) -> letter = 'm'.toString()
            (remain == 23) -> letter = 'n'.toString()
            (remain == 24) -> letter = 'o'.toString()
            (remain == 25) -> letter = 'p'.toString()
            (remain == 26) -> letter = 'q'.toString()
            (remain == 27) -> letter = 'r'.toString()
            (remain == 28) -> letter = 's'.toString()
            (remain == 29) -> letter = 't'.toString()
            (remain == 30) -> letter = 'u'.toString()
            (remain == 31) -> letter = 'v'.toString()
            (remain == 32) -> letter = 'w'.toString()
            (remain == 33) -> letter = 'x'.toString()
            (remain == 34) -> letter = 'y'.toString()
            (remain == 35) -> letter = 'z'.toString()
        }
        if (remain >= 10)
            result += letter
        else result += remain.toString()
        number /= base
    }
    return result.reversed()
}


/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    val size = digits.size
    var result = 0.0
    for (i in 0 until size) {
        val ext = abs(i + 1.0 - size + 0.0)
        var number = digits[i] * pow(base + 0.0, ext)
        result += number
    }
    return result.toInt()
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val size = str.length
    var result = 0.0
    var mul = 0
    for (i in str.length - 1 downTo 0) {
        val ext = abs(i + 1.0 - size + 0.0)
        when {
            (str[i] == 'a') -> mul = 10
            (str[i] == 'b') -> mul = 11
            (str[i] == 'c') -> mul = 12
            (str[i] == 'd') -> mul = 13
            (str[i] == 'e') -> mul = 14
            (str[i] == 'f') -> mul = 15
            (str[i] == 'g') -> mul = 16
            (str[i] == 'h') -> mul = 17
            (str[i] == 'i') -> mul = 18
            (str[i] == 'j') -> mul = 19
            (str[i] == 'k') -> mul = 20
            (str[i] == 'l') -> mul = 21
            (str[i] == 'm') -> mul = 22
            (str[i] == 'n') -> mul = 23
            (str[i] == 'o') -> mul = 24
            (str[i] == 'p') -> mul = 25
            (str[i] == 'q') -> mul = 26
            (str[i] == 'r') -> mul = 27
            (str[i] == 's') -> mul = 28
            (str[i] == 't') -> mul = 29
            (str[i] == 'u') -> mul = 30
            (str[i] == 'v') -> mul = 31
            (str[i] == 'w') -> mul = 32
            (str[i] == 'x') -> mul = 33
            (str[i] == 'y') -> mul = 34
            (str[i] == 'z') -> mul = 35
            else -> mul = str[i] - '0'
        }
        var number = mul * pow(base + 0.0, ext)
        result += number
    }
    return result.toInt()
}


/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String = TODO()

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String = TODO()