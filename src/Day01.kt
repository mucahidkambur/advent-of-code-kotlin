fun main() {
    fun part1(input: List<String>): Int {
        var tempValue: Int? = null
        var count = 0

        input.forEach { number ->
            val numberInInt = number.toInt()

            if (tempValue == null) {
                tempValue = numberInInt
                return@forEach
            }

            if (numberInInt > tempValue!!) {
                count++
            }

            tempValue = numberInInt
        }

        return count
    }

    fun part2(input: List<String>): Int {
        var tempValue: Int? = null
        var count = 0
        val windowList = input.windowed(3, 1)

        windowList.forEach { window ->
            if (tempValue == null) {
                tempValue = window.sumOf { it.toInt() }
                return@forEach
            }

            val sum = window.sumOf { it.toInt() }
            if (sum > tempValue!!) {
                count++
            }

            tempValue = sum

        }
        return count
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
