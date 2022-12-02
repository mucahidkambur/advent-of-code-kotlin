package day02

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        return input.sumOf { round ->
            val (opponent, me) = round.split(" ")
            val opponentShape = Shape.values().find { it.opponent == opponent }!!
            val myShape = Shape.values().find { it.me == me }!!

            when (opponentShape.getState(myShape)) {
                RoundState.WIN -> {
                    myShape.point
                }

                RoundState.DRAW -> {
                    myShape.point + RoundState.DRAW.point
                }

                else -> {
                    myShape.point + RoundState.WIN.point
                }
            }
        }
    }

    fun part2(input: List<String>): Int {
        return input.sumOf { round ->
            val (opponent, me) = round.split(" ")
            val opponentShape = Shape.values().find { it.opponent == opponent }!!
            val myState = RoundState.values().find { it.me == me }!!

            val myShape = opponentShape.getShape(myState)

            when (myState) {
                RoundState.WIN -> {
                    myShape.point + RoundState.WIN.point
                }

                RoundState.DRAW -> {
                    myShape.point + RoundState.DRAW.point
                }

                RoundState.LOSE -> {
                    myShape.point
                }
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("day02/Day02")
    println(part1(input))
    println(part2(input))
}

enum class Shape(val opponent: String, val me: String, val point: Int) {
    ROCK("A", "X", 1),
    PAPER("B", "Y", 2),
    SCISSORS("C", "Z", 3);

    fun getShape(roundState: RoundState): Shape {
        return when {
            this == ROCK && roundState == RoundState.WIN -> PAPER
            this == ROCK && roundState == RoundState.DRAW -> ROCK
            this == ROCK && roundState == RoundState.LOSE -> SCISSORS
            this == PAPER && roundState == RoundState.WIN -> SCISSORS
            this == PAPER && roundState == RoundState.DRAW -> PAPER
            this == PAPER && roundState == RoundState.LOSE -> ROCK
            this == SCISSORS && roundState == RoundState.WIN -> ROCK
            this == SCISSORS && roundState == RoundState.DRAW -> SCISSORS
            this == SCISSORS && roundState == RoundState.LOSE -> PAPER
            else -> throw Exception()
        }
    }

    fun getState(me: Shape): RoundState {
        return when {
            this == ROCK && me == ROCK -> RoundState.DRAW
            this == ROCK && me == PAPER -> RoundState.LOSE
            this == ROCK && me == SCISSORS -> RoundState.WIN
            this == PAPER && me == ROCK -> RoundState.WIN
            this == PAPER && me == PAPER -> RoundState.DRAW
            this == PAPER && me == SCISSORS -> RoundState.LOSE
            this == SCISSORS && me == ROCK -> RoundState.LOSE
            this == SCISSORS && me == PAPER -> RoundState.WIN
            this == SCISSORS && me == SCISSORS -> RoundState.DRAW
            else -> throw Exception()
        }
    }
}

enum class RoundState(val point: Int, val me: String) {
    WIN(6, "Z"),
    DRAW(3, "Y"),
    LOSE(0, "X")
}
