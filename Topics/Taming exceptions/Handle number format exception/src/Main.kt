fun parseCardNumber(cardNumber: String): Long {
    val regEx = Regex("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}")
    val invalidCardNumberException = Exception("Invalid Card Number!")
    if (cardNumber.matches(regEx)) return cardNumber.replace(" ", "").toLong()
    throw invalidCardNumberException
}
