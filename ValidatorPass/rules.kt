import java.io.File
import kotlin.math.log2

abstract class Rule() {
    open fun check(password: String):Boolean {
        return false
    }
    open val description: String = ""
}

class lengthPassword () : Rule() {
    override val description: String = "Ошибка! Длина пароля не соответствует условию"
    override fun check(password: String): Boolean {
        if (password.length < 8 || password.length  > 20) {
            return false
        }
        return true
    }
}

class upperLowerCase (): Rule(){
    override val description: String = "Ошибка! Пароль не содержит символы нижнего и верхнего регистра"
    override fun check(password: String): Boolean {
        var lower = false
        var upper = false

        for (c: Char in password){
            if (c in 'a'..'z')
                lower = true
            else if (c in 'A'..'Z')
                upper = true
        }
        return (lower && upper)
    }
}

class specSigns (): Rule() {
    override val description: String = "Ошибка! Пароль не содержит специальные символы"
    val signs = arrayListOf('!', '@','№', '#', '$', '%', '^', '&', '*', '(', ')', '+', '-', '_', '=', '`', '~',
        '<', '>', '?', '/', ':', '\'', '[', ']', '{', '}', "/\\", '|', '"')
    override fun check(password: String) : Boolean {
        for (c: Char in password) {
            if (c in signs)
                return true
        }
        return false
    }
}
class DictinaryWords (): Rule() {
    override val description: String = "Ошибка! Пароль не должен содержать словарные слова"
    override fun check(password: String): Boolean {
        val dictionary = File("src\\pswd-dict.txt")
        val words = ArrayList<String>()
        dictionary.forEachLine {
            words.addAll(it.split(" "))
        }
        if (password in words)
            return false
        return true
    }
}
class entropy (): Rule() {
    override val description: String = "Ошибка! Пароль должен иметь высокий уровень энтропии"
    override fun check(password: String): Boolean {
        var H = 0.0
        val freq = HashMap<Char, Double>()
        for (c: Char in password){
            if (!freq.containsKey(c)) {
                freq.put(c, 1.0)
            }
            else {
                freq.put(c, freq.getValue(c) + 1.0)
            }
        }
        val dictSize = freq.size
        for (f in freq){
            f.setValue(f.value / dictSize)
            H += f.value * log2(f.value)
        }
        H = -H
        if (H > 1)
            return true
        return false
    }
}
