package day04

import readInput
fun main() {

    fun part1(input: List<String>): Int {
        var totalPairs = 0

        input.map { pair ->
            pair.split(delimiters = arrayOf(",", "-")).map(String::toInt)
        }.map {
            it.chunked(2)
        }.forEach {
            val firstListRange = it.component1().component1().rangeTo(it.component1().component2())
            val firsList = it.component1()
            val secondListRange = it.component2().first().rangeTo(it.component2().component2())
            val secondList = it.component2()

            if (secondList.all { it in firstListRange} || firsList.all { it in secondListRange }) {
                totalPairs += 1
            }
        }

        return totalPairs
    }

    fun part2(input: List<String>): Int {
        var totalPairs = 0

        input.map { pair ->
            pair.split(delimiters = arrayOf(",", "-")).map(String::toInt)
        }.map {
            it.chunked(2)
        }.forEach {
            val firstListRange = it.component1().component1().rangeTo(it.component1().component2())
            val firsList = it.component1()
            val secondListRange = it.component2().first().rangeTo(it.component2().component2())
            val secondList = it.component2()

            if (secondList.any { it in firstListRange} || firsList.any { it in secondListRange }) {
                totalPairs += 1
            }
        }

        return totalPairs
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day04/Day04")
    println(part1(input))
    println(part2(input))
}
