package day03

import readInput

const val GROUP_PER = 3

fun main() {

    fun Char.findUppercasePriority(): Int = this.code - 'A'.code.dec() + ('z'.code - 'a'.code).inc()

    fun Char.findLowercasePriority(): Int = this.code - 'a'.code.dec()

    fun part1(input: List<String>): Int {
        return input.sumOf { rucksack ->
            val (firstPart, secondPart) = rucksack.chunked(rucksack.length / 2)

            val commonChar = firstPart.first { char -> secondPart.contains(char) }
            when {
                commonChar.isUpperCase() -> {
                    commonChar.findUppercasePriority()
                }
                else -> {
                    commonChar.findLowercasePriority()
                }
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.chunked(GROUP_PER).sumOf { rucksacks ->
            val commonItemType = rucksacks.joinToString(separator = "").first { char ->
                rucksacks.count { it.contains(char) } > 2
            }

            when {
                commonItemType.isUpperCase() -> {
                    commonItemType.findUppercasePriority()
                }
                else -> {
                    commonItemType.findLowercasePriority()
                }
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day03/Day03")
    println(part1(input))
    println(part2(input))
}
