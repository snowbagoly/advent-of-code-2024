import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val pairs = input.map { line -> line.split(Regex("\\s+")) }
        val lefts = pairs.map { pair -> pair[0].toInt() }.sorted()
        val rights = pairs.map { pair -> pair[1].toInt() }.sorted()
        return lefts.zip(rights).map { (left, right) -> abs(left - right) }.sum()
    }

    fun part2(input: List<String>): Int {
        val pairs = input.map { line -> line.split(Regex("\\s+")) }
        val lefts = pairs.map { pair -> pair[0].toInt() }.sorted()
        val rights = pairs.map { pair -> pair[1].toInt() }.sorted()
        return lefts.map { left -> left * rights.count { right -> right == left } }.sum()
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
