import kotlin.math.abs
import kotlin.math.max

fun main() {
    fun isSafe(report: List<Int>): Boolean {
        return (report.sorted() == report || report.sortedDescending() == report) &&
                report.indices.drop(1).all { index -> abs(report[index] - report[index - 1]) in 1..3 }
    }

    fun hasFix(report: List<Int>): Boolean {
        return report.indices.any { index -> isSafe(report.take(index) + report.drop(index + 1)) }
    }

    fun part1(input: List<String>): Int {
        val reports = input.map { line -> line.split(" ").map { it.toInt() } }
        return reports.count { report -> isSafe(report) }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { line -> line.split(" ").map { it.toInt() } }
        return reports.count { report -> isSafe(report) || hasFix(report) }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
