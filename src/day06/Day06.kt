package day06

import readInput

fun main() {

    fun String.proceed(windowSize: Int): Int {
        return this
            .windowed(windowSize)
            .first { s ->
                s.length == s.toCharArray().distinct().joinToString("").length
            }.let { distinctPart ->
                this.indexOf(distinctPart).plus(distinctPart.length)
            }
    }

    fun part1(input: String): Int {
        return input.proceed(windowSize = 4)
    }

    fun part2(input: String): Int {
        return input.proceed(windowSize = 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/Day06_test").first()
    check(part1(testInput) == 10)
    check(part2(testInput) == 29)

    val input = readInput("day06/Day06").first()
    println(part1(input))
    println(part2(input))
}
