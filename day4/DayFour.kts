val winners: Set<Int> = setOf(41, 48, 83, 86, 17)
val owned: Set<Int> = setOf(83, 86,  6, 31, 17,  9, 48, 53)
val numWon: Int = owned.filter{i -> i in winners}.count()
val amountWon: Int = Math.pow(2.0, numWon - 1.0).toInt()

println("you won ${amountWon}")