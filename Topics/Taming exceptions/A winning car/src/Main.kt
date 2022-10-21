import java.lang.Exception

fun findCar(): String {
    val maxSpeed = readln().toInt()
    val accTime = readln().toInt()

    // write your code here
    val carException = Exception("The race can't be won with this car")

    if (maxSpeed < 120 || accTime > 4 || accTime < 1) throw carException

    return "I will definitely win!"
}