package cinema

import java.text.DecimalFormat

var currentIncome = 0
var purchased = 0

fun main() {
    // get the numbers
    println("Enter the number of rows:")
    val rows = readln().toInt()
    println("Enter the number of seats in each row:")
    val seats = readln().toInt()

    val saloon = mutableListOf<MutableList<String>>()

    val total = rows * seats
    val totalIncome = if (total > 60) total * 8 + (rows / 2).toInt() * seats * 2 else total * 10

    // create saloon grid
    for (row in 0 until rows) saloon.add(mutableListOf())
    for (row in saloon) for (seat in 0 until seats) row.add("S")

    menu@ while (true) {
        println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit")
        when (readln().toInt()) {
            1 -> displaySaloon(saloon)
            2 -> buyATicket(saloon, total, rows)
            3 -> showStatistics(total, totalIncome)
            0 -> break@menu
        }
    }
}

fun showStatistics(total: Int, totalIncome: Int) {
    println("Number of purchased tickets: $purchased")
    val percent = purchased.toDouble() / total.toDouble() * 100.0
    val formattedPercent = String.format("%.2f", percent)
    println("Percentage: $formattedPercent%")
    println("Current income: \$$currentIncome")
    println("Total income: \$$totalIncome")
}

fun displaySaloon(saloon: MutableList<MutableList<String>>) {
    println()
    print("Cinema:\n ")
    val seats = saloon[0].size
    for (seat in 1..seats) print(" $seat")
    var index = 1
    for (row in saloon) {
        println()
        print("${index++}")
        for (seat in row) print(" $seat")
    }
    println()
}

fun buyATicket(saloon: MutableList<MutableList<String>>, total: Int, rows: Int) {
    println("Enter a row number:")
    val row = readln().toInt() - 1
    println("Enter a seat number in that row:")
    val seatNo = readln().toInt() - 1

    try {
        if (saloon[row][seatNo] == "B") {
            println("That ticket has already been purchased!")
            buyATicket(saloon, total, rows)
        } else {
            val ticketPrice: Int = if (total <= 60 || row < rows / 2) 10
            else 8
            saloon[row][seatNo] = "B"
            println("Ticket price: \$$ticketPrice")
            currentIncome += ticketPrice
            purchased += 1
        }
    } catch (e: IndexOutOfBoundsException) {
        println("Wrong input!")
        buyATicket(saloon, total, rows)
    }
}