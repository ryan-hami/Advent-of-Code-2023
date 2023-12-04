import java.io.File

val nSpaces = "\\s+".toRegex()

fun partTwo() {
    val cardMap: MutableList<Int> = mutableListOf()

    val lines = File("C:\\Users\\rlham\\aoc\\2023\\day4\\input.txt").forEachLine {
        val indexOfPipe = it.indexOf("|")

        val winners = it.substring(it.indexOf(":") + 1, indexOfPipe).trim().split(nSpaces)
        val owned = it.substring(indexOfPipe + 1).trim().split(nSpaces)

        val numWon = owned.filter {e -> e in winners}.count()

        cardMap.add(numWon)
    }

    val accumulationMap: MutableList<Int> = MutableList(cardMap.size) {1}
    for (i in 0 until cardMap.size) {
        for (j in 1..accumulationMap[i]) {
            for (k in 1..cardMap[i]) {
                accumulationMap[i + k] += 1
            }
        }
    }

    println("part two: you won ${accumulationMap.sum()} cards")
}

fun partOne() {
    var sum = 0
    val nSpaces = "\\s+".toRegex()
    File("C:\\Users\\rlham\\aoc\\2023\\day4\\input.txt").forEachLine {
        val indexOfPipe = it.indexOf("|")

        val winners = it.substring(it.indexOf(":") + 1, indexOfPipe).trim().split(nSpaces)
        val owned = it.substring(indexOfPipe + 1).trim().split(nSpaces)

        val numWon = owned.filter {e -> e in winners}.count()
        val amountWon = Math.pow(2.0, numWon - 1.0).toInt()

        sum += amountWon
    }

    println("part one: you won $sum points")
}

partOne()
partTwo()
