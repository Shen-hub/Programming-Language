fun isNumber(s: String): Boolean {
    if (s.isEmpty()) return false
    for (symbol in s) {
        if (!symbol.isDigit()) {
            return false
        }
    }
    return true
}

fun main(args: Array<String>) {

    val ops = arrayOf("+", "-", "*", "/")

    println("Введите выражение:")
    var answer: String? = readLine()
    val stack = mutableListOf<String>()

    if (!answer.isNullOrEmpty()) {
        val parts = answer?.split(' ')
        var x = 0
        var y = 0
        for (part in parts.reversed()) {
            if (isNumber(part)) {
                stack.add(0, part)
                x += 1
            } else {
                if (part in ops) {
                    y +=1
                    if (stack.size >= 2) {
                        var part = part
                        var first = stack.first()
                        stack.removeAt(0)
                        var sec= stack.first()
                        stack.removeAt(0)

                        stack.add(0, "("+first+part+sec+")")
                    } else {
                        stack.add(stack.lastIndex, part)
                    }
                } else {
                    println("Неправильное выражение")
                    return
                }
            }
        }

        if (stack.size > 1) {
            println("Результат: ${stack.joinToString("")}")
        }
        else if (stack.isEmpty()) {
            println("Неправильное выражение")
        }
        else if ((y+1) != x){
            println("Неправильное выражение")
        }
        else {
            println("Результат: ${stack.removeAt(stack.lastIndex)}")
        }
    }
    else {
        println("Неправильное выражение")
    }
}
