import java.io.File

val input = File("C:\\Users\\rlham\\aoc\\2023\\day5\\input.txt")
val lines = input.readLines()

val seeds = lines[0].substring(7).split("\\s".toRegex()).map { s -> s.toLong() }
val maps: List<MutableMap<LongRange, Long>> = List(7) { mutableMapOf() }

var index = -1
for (line in lines.drop(2)) {
    if (line == "") continue
    if (line.lastIndexOf(":") != -1) {
        ++index
        continue
    }

    val entry = line.split(" ")
    val destination = entry[0].toLong()
    val source = entry[1].toLong()
    val length = entry[2].toLong()

    val map = maps[index]
    map.put(source until source + length, destination - source)
}

fun getLocation(seed: Long): Long = maps.fold(seed) { source, map -> map.keys.firstOrNull { source in it }?.let { range -> source + map[range]!! } ?: source }
val locations = seeds.map(::getLocation)
println(locations.min())
