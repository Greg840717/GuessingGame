package com.example.guessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.nio.file.Files.find

class MainActivity : AppCompatActivity() {

    private lateinit var playerName: EditText
    private lateinit var status: TextView
    private lateinit var scissors: RadioButton
    private lateinit var stone: RadioButton
    private lateinit var paper: RadioButton
    private lateinit var start: Button
    private lateinit var player: TextView
    private lateinit var winner: TextView
    private lateinit var mine: TextView
    private lateinit var computer: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playerName = findViewById(R.id.PlayerName)
        status = findViewById(R.id.Status)
        scissors = findViewById(R.id.Scissors)
        stone = findViewById(R.id.Stone)
        paper = findViewById(R.id.Paper)
        start = findViewById(R.id.Start)
        player = findViewById(R.id.Player)
        winner = findViewById(R.id.Winner)
        mine = findViewById(R.id.Mine)
        computer = findViewById(R.id.Computer)

        initialLayoutText()
        start.setOnClickListener {
            if (playerName.length() < 1) {
                status.setText("請輸入玩家姓名")
            } else {
                val computerGuess = (Math.random() * 3).toInt()
                var playerGuess = 0
                if (scissors.isChecked) {
                    playerGuess = 0
                } else if (stone.isChecked) {
                    playerGuess = 1
                } else {
                    playerGuess = 2
                }
                judgeWinner(playerGuess, computerGuess)
            }
        }
    }

    fun initialLayoutText() {
        playerName.setHint(R.string.hint)
        status.setText(R.string.status)
        scissors.setText("剪刀")
        stone.setText("石頭")
        paper.setText("布")
        start.setText("開始")
        player.setText("名子")
        winner.setText("贏家")
        mine.setText("玩家出拳")
        computer.setText("電腦出拳")
        scissors.isChecked = true
    }

    fun judgeWinner(a: Int, b: Int) {
        var win = 0
        if (a == 0) {
            when (b) {
                0 -> {
                    win = 2
                }
                1 -> {
                    win = 1
                }
                2 -> {
                    win = 0
                }

            }
        } else if (a == 1) {
            when (b) {
                0 -> {
                    win = 0
                }
                1 -> {
                    win = 2
                }
                2 -> {
                    win = 1
                }
            }
        } else {
            when (b) {
                0 -> {
                    win = 1
                }
                1 -> {
                    win = 0
                }
                2 -> {
                    win = 2
                }
            }
        }
        settingTextview(a, b, win)
    }

    fun settingTextview(plaYer: Int, comPuter: Int, winNer: Int) {
        player.setText("名子\n" + PlayerName.text.toString())
        when (plaYer) {
            0 -> mine.setText("玩家出拳\n剪刀")
            1 -> mine.setText("玩家出拳\n石頭")
            2 -> mine.setText("玩家出拳\n布")
        }
        when (comPuter) {
            0 -> computer.setText("電腦出拳\n剪刀")
            1 -> computer.setText("電腦出拳\n石頭")
            2 -> computer.setText("電腦出拳\n布")
        }
        when (winNer) {
            0 -> {
                status.setText("玩家勝利!")
                winner.setText("贏家\n" + PlayerName.text.toString())
            }
            1 -> {
                status.setText("電腦勝利!")
                winner.setText("贏家\n電腦")
            }
            2 -> {
                status.setText("平手")
                winner.setText("贏家\n平手")
            }
        }
    }


}
