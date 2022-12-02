package day01

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        val totalCaloriesPerElf = mutableListOf<Int>()

        var tempValue = 0
        input.forEach { calorie ->
            if (calorie.isNotBlank()) {
                tempValue += calorie.toInt()
            } else {
                totalCaloriesPerElf.add(tempValue)
                tempValue = 0
            }
        }

        return totalCaloriesPerElf.apply { sortDescending() }.first()
    }

    fun part2(input: List<String>): Int {
        val totalCaloriesPerElf = mutableListOf<Int>()

        var tempValue = 0
        input.forEach { calorie ->
            if (calorie.isNotBlank()) {
                tempValue += calorie.toInt()
            } else {
                totalCaloriesPerElf.add(tempValue)
                tempValue = 0
            }
        }

        return totalCaloriesPerElf.apply { sortDescending() }.take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 68292)
    check(part2(testInput) == 203203)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
