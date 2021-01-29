fun main(args: Array<String>) {

    println("Введите пароль, которой состоит из 8-20 символов, включает цифры и специальные символы, символы нижнего и верхнего регистра.")
    val password = readLine().toString()
    val validator = Validator()
    validator.addRule(lengthPassword())
    validator.addRule(upperLowerCase())
    validator.addRule(specSigns())
    validator.addRule(DictinaryWords())
    validator.addRule(entropy())

    if (validator.validate(password)) {
        println("Пароль прошёл валидацию. Все условия соблюдены.")
    } else {
        println(validator.errors)
    }
}
