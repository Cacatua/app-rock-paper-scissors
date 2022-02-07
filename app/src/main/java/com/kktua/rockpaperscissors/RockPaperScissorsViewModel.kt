package com.kktua.rockpaperscissors

import kotlin.random.Random

class RockPaperScissorsViewModel {

    private var appChoice: Int = 0

    fun play() {
        appChoice = Random.nextInt(3)
    }

    fun result(userChoice: Int): CharSequence {
        var result = "Resultado não previsto"

        when (this.appChoice) {
            userChoice -> result = "Empatamos ;)"
            RockPaperScissors.Paper.ordinal -> {
                result = if (userChoice == RockPaperScissors.Scissors.ordinal) "Usuario ganhou"
                else "App ganhou"

            }
            RockPaperScissors.Rock.ordinal -> {
                result = if (userChoice == RockPaperScissors.Paper.ordinal) "Usuario ganhou"
                else "App ganhou"

            }
            RockPaperScissors.Scissors.ordinal -> {
                result = if (userChoice == RockPaperScissors.Rock.ordinal) "Usuario ganhou"
                else "App ganhou"
            }
        }

        return result
    }

    fun appImageChoice(): Int =
        when (this.appChoice) {
            RockPaperScissors.Rock.ordinal -> R.drawable.pedra
            RockPaperScissors.Paper.ordinal -> R.drawable.papel
            RockPaperScissors.Scissors.ordinal -> R.drawable.tesoura
            else -> R.drawable.padrao
        }
}