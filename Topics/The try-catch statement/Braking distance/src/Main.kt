fun calculateBrakingDistance(v1: String, a: String): Int {
    val v2 = 0
    return try {
        return v2 * v2 - v1.toInt() * v1.toInt() / (2 * a.toInt())
    } catch (e: ArithmeticException) {
        println("The car does not slow down!")
        -1
    } catch (e: NumberFormatException) {
        println("For input string: \"${if (v1.matches(Regex("[0-9]*"))) a else v1}\"")
        -1
    }
}