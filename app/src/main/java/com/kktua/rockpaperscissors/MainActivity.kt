package com.kktua.rockpaperscissors

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kktua.rockpaperscissors.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        imageListeners()
    }

    private fun imageListeners() {
        binding.ivPaper.setOnClickListener {
            play(RockPaperScissors.Paper.ordinal)
        }

        binding.ivRock.setOnClickListener {
            play(RockPaperScissors.Rock.ordinal)
        }

        binding.ivScissors.setOnClickListener {
            play(RockPaperScissors.Scissors.ordinal)
        }
    }

    private fun play(userChoice: Int) {
        val rockPaperScissorsViewModel = RockPaperScissorsViewModel()

        rockPaperScissorsViewModel.play()
        binding.tvResult.text = rockPaperScissorsViewModel.result(userChoice)
        binding.ivAppChoice.setImageResource(rockPaperScissorsViewModel.appImageChoice())
    }

}