import java.math.BigInteger

fun main() {
    fun combinePart1(operands: List<BigInteger>, currentResult: BigInteger, expectedResult: BigInteger): Boolean {
        if (operands.isEmpty()) {
            return currentResult == expectedResult
        }
        if (currentResult > expectedResult) {
            return false
        }
        val nextOperand = operands[0]
        val otherOperands = operands.drop(1)
        return combinePart1(otherOperands, currentResult * nextOperand, expectedResult) ||
                combinePart1(otherOperands, currentResult + nextOperand, expectedResult)
    }

    fun combinePart2(operands: List<BigInteger>, currentResult: BigInteger, expectedResult: BigInteger): Boolean {
        if (operands.isEmpty()) {
            return currentResult == expectedResult
        }
        if (currentResult > expectedResult) {
            return false
        }
        val nextOperand = operands[0]
        val otherOperands = operands.drop(1)
        return combinePart2(otherOperands, currentResult * nextOperand, expectedResult) ||
                combinePart2(otherOperands, currentResult + nextOperand, expectedResult) ||
                combinePart2(otherOperands, (currentResult.toString() + nextOperand.toString()).toBigInteger(), expectedResult)
    }

    fun part1(input: List<String>): BigInteger {
        var sum = "0".toBigInteger()
        for (line in input) {
            val splittedLine = line.split(": ")
            val result = splittedLine[0].toBigInteger()
            val operands = splittedLine[1].split(" ").map { operand -> operand.toBigInteger() }
            val foundResult = combinePart1(operands.drop(1), operands[0], result)
            if (foundResult) {
                sum += result
            }
        }
        return sum
    }

    fun part2(input: List<String>): BigInteger {
        var sum = "0".toBigInteger()
        for (line in input) {
            val splittedLine = line.split(": ")
            val result = splittedLine[0].toBigInteger()
            val operands = splittedLine[1].split(" ").map { operand -> operand.toBigInteger() }
            val foundResult = combinePart2(operands.drop(1), operands[0], result)
            if (foundResult) {
                sum += result
            }
        }
        return sum
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == BigInteger("3749"))
    check(part2(testInput) == BigInteger("11387"))

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day07")
    part1(input).println()
    part2(input).println()
}
