import java.io.File

var sum = 0
val nSpaces = "\\s+".toRegex()
File("C:\\Users\\rlham\\aoc\\2023\\day4\\input.txt").forEachLine {
    val indexOfPipe = it.indexOf("|")

    val winners = it.substring(it.indexOf(":") + 1, indexOfPipe).trim().split(nSpaces)
    val owned = it.substring(indexOfPipe + 1).trim().split(nSpaces)

    val numWon = owned.filter{e -> e in winners}.count()
    val amountWon = Math.pow(2.0, numWon - 1.0).toInt()

    sum += amountWon
}

println("in all you won $$sum")
