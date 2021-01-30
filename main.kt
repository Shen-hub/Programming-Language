class Temp (val temp: Double, val type: Char) {
    val celsius: Double = ToCelsius(temp, type)
    val fahrenheit: Double = ToFahrenheit(temp, type)
    val kelvin: Double = ToKelvin(temp, type)
    fun ToFahrenheit (temp: Double, type:Char): Double {
        if (type == 'c' || type == 'C')
            return 1.8*temp+32
        if (type == 'k' || type == 'K')
            return 1.8*(temp-273)+32
        return temp
    }

    fun ToKelvin (temp: Double, type:Char): Double {
        if (type == 'c' || type == 'C')
            return temp+273
        if (type == 'f' || type == 'F')
            return (temp+459)/1.8
        return temp
    }

    fun ToCelsius (temp: Double, type:Char): Double {
        if (type == 'k' || type == 'K')
            return temp-273
        if (type == 'f' || type == 'F')
            return (temp-32)/1.8
        return temp
    }
}

fun main(args: Array<String>) {
    println("Введите температуру")
    val temp = readLine()!!.toDouble()
    println("Укажите единицу измерения температуры (принимаются следующие обозначения: k - Кельвин, f - Фаренгейт, c - Цельсия)")
    val type:Char = readLine()!!.toCharArray()[0]
    val arrayChars = arrayOf('k', 'K', 'f', 'F', 'c', 'C')

    if (arrayChars.contains(type))
    {
        val t: Temp = Temp(temp, type)
        println("Градус Цельсия: ${t.celsius} \nГрадус Фаренгейта: ${t.fahrenheit} \nКельвин: ${t.kelvin}")
    }

    else
        println("Ошибка ввода единицы измерения температуры")
}
