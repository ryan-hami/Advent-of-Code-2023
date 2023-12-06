import java.io.File

val input = File("C:\\Users\\rlham\\aoc\\2023\\day5\\input.txt")
val lines = input.readLines()

val seeds = lines[0].substring(7).split("\\s".toRegex()).map { s -> s.toInt() }
val maps: List<MutableMap<Int, Int>> = List(7) { mutableMapOf() }

var index = -1
for (i in 2 until lines.size) {
    val line = lines[i]
    if (line == "") continue
    if (line.lastIndexOf(":") != -1) {
        ++index
        continue
    }

    val entry = line.split(" ")
    val destination = entry[0].toInt()
    val source = entry[1].toInt()
    val length = entry[2].toInt()

    val map = maps[index]
    for (i in 0 until length) {
        map.put(source + i, destination + i)
    }
}

fun getLocation(seed: Int): Int =
    maps.fold(seed) { source, map -> map[source] ?: source }
val locations = seeds.map(::getLocation)

println(locations.min())